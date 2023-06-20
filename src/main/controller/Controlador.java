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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            int idC = Integer.parseInt(request.getParameter("idC"));
            String detalles = request.getParameter("detallesG");
            String fechaHora = request.getParameter("fechaHora");
            double importe = Double.parseDouble(request.getParameter("importe"));
            int idU = Integer.parseInt(request.getParameter("idU"));
            Gastos g = new Gastos(idC,fechaHora,detalles,importe,idU);
            gastosDAO.create(g);
            boolean resultado = gastosDAO.read(g);

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
                  request.getSession().setAttribute("usuario",u.getIdU());
                  request.getRequestDispatcher("gestion.jsp").forward(request, response);
              }else {

                  msnError = "Error de Usuario o Contraseña";
                  request.setAttribute("msnError", msnError);
                  request.getRequestDispatcher("index.jsp").forward(request, response);
              }

    }
}