package controller;

import modell.Usuario;
import services.UsuarioDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "controlador", value = "/controlador")
public class Controlador extends HttpServlet {
    UsuarioDAO userDao = new UsuarioDAO();
    String msnExito, msnError;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 /*       Usuario u = new Usuario("Azucena", "123456");
        UsuarioDAO a = new UsuarioDAO();
     //   boolean msn = a.create(u);
        boolean msn = a.update(u);
        System.out.println(msn);
*/



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String user = request.getParameter("userN");
          String pass = request.getParameter("passU");
          Usuario u = new Usuario(user, pass);
          boolean resultado = userDao.read(u);
              if (resultado) {
                  request.getRequestDispatcher("gestion.jsp").forward(request, response);
              }else {

                  msnError = "Error de Usuario o Contraseña";
                  request.setAttribute("msnError", msnError);
                  request.getRequestDispatcher("index.jsp").forward(request, response);
              }
    }
}