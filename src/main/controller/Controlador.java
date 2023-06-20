package controller;

import modell.Gastos;
import modell.Usuario;
import services.CategoriasDAO;
import services.GastosDAO;
import services.UsuarioDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "controlador", value = "/controlador")
public class Controlador extends HttpServlet {
    UsuarioDAO userDao = new UsuarioDAO();
    GastosDAO gastosDAO = new GastosDAO();
    CategoriasDAO catDao = new CategoriasDAO();
    String msnExito, msnError;
    int usuarioSesion;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            int idC = Integer.parseInt(request.getParameter("idC"));
            String detalles = request.getParameter("detallesG");
            String fechaHora = request.getParameter("fechaHora");
            double importe = Double.parseDouble(request.getParameter("importe"));
            int idU = usuarioSesion;
            Gastos g = new Gastos(idC,fechaHora,detalles,importe,idU);
            boolean resultado = gastosDAO.create(g);
            if (resultado) {

                request.getRequestDispatcher("gestion.jsp").forward(request, response);
            } else {
                msnError = "Error en la gestión";
                request.setAttribute("msnError", msnError);
                request.getRequestDispatcher("gestion.jsp").forward(request, response);
            }
        }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String user = request.getParameter("userN");
          String pass = request.getParameter("passU");
          Usuario u = new Usuario(user, pass);
          boolean resultado = userDao.read(u);
              if (resultado) {
                  Usuario usuarioS= new Usuario();
                  usuarioS=userDao.readUsuarioSesion(u);
                  usuarioSesion=usuarioS.getIdU();
                  balance(request,response);

              }else {

                  msnError = "Error de Usuario o Contraseña";
                  request.setAttribute("msnError", msnError);
                  request.getRequestDispatcher("index.jsp").forward(request, response);
              }

    }

    protected void balance(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Gastos> gastos=gastosDAO.readAllTipo(1);
        ArrayList<Gastos> ingresos=gastosDAO.readAllTipo(2);
        System.out.println(gastos.toString());
        double gastosTotal=0,ingresoTotal=0;
        for(Gastos g:gastos){
            gastosTotal+=g.getImporteG();

        }
        for(Gastos g:ingresos){
            ingresoTotal+=g.getImporteG();
        }
        if (gastosTotal>ingresoTotal){
            request.setAttribute("mayor",gastosTotal);
            request.setAttribute("menor",ingresoTotal);
        }else{

            request.setAttribute("mayor",ingresoTotal);
            request.setAttribute("menor",gastosTotal);
        }
        System.out.println(ingresoTotal);
        request.setAttribute("ingresoTotal",ingresoTotal);
        request.setAttribute("gastosTotal",gastosTotal);
        request.setAttribute("gastos",gastos);
        request.setAttribute("ingresos",ingresos);
        request.getRequestDispatcher("balance.jsp").forward(request,response);

    }

}