package controller;


import modell.Gastos;
import services.GastosDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ConCat", value = "/ConCat")
public class ConCat extends HttpServlet {
    String msn;
     GastosDAO dao = new GastosDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Usuario u = new Usuario("Azucena", "123456");
//        UsuarioDAO a = new UsuarioDAO();
//        //   boolean msn = a.create(u);
//        boolean msn = a.update(u);
//        System.out.println(msn);
//
//         Categorias cat=new Categorias("Gastos Telefono",1,"telefono" );
//         CategoriasDAO catDAO=new CategoriasDAO();
//         Boolean respuesta=catDAO.read(cat);
//
//         if(respuesta){
//             catDAO.delete(cat);
//         }
//        System.out.println(respuesta);
          //  Gastos g = new Gastos("2023-05-30", 3,1000,"Nomina",1 );
        GastosDAO ga = new GastosDAO();
        ArrayList<Gastos> miLista= new ArrayList<>();
        miLista=ga.readAllTipo(2);

           System.out.println(miLista.toString());


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}