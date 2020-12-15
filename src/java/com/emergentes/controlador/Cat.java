
package com.emergentes.controlador;

import com.emergentes.dao.CategoriasDAO;
import com.emergentes.dao.CategoriasDAOimpl;
import com.emergentes.modelo.Categorias;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Cat", urlPatterns = {"/Cat"})
public class Cat extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try {
            CategoriasDAO dao = new CategoriasDAOimpl();
            int id;
            Categorias est = new Categorias();
            String action = (request.getParameter("action") != null) ? request.getParameter("action"):"view";
            switch(action){
                case "add":
                    request.setAttribute("categorias", est);
                    request.getRequestDispatcher("frmcat.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    est = dao.getById(id);
                    request.setAttribute("categorias", est);
                    request.getRequestDispatcher("frmcat.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Cat");
                    break;
                default:
                    id = (int)request.getSession().getAttribute("id");
                    List<Categorias> lista = dao.getAll(id);
                    request.setAttribute("categorias", lista);
                    request.getRequestDispatcher("AdministrarCat.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CategoriasDAO dao = new CategoriasDAOimpl();
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");

        
        Categorias est = new Categorias();
        est.setId(id);
        est.setDescripcion(descripcion);
        
        if(id == 0){
            try {
                int id_usuario = (int)request.getSession().getAttribute("id");
                est.setId_usuario(id_usuario);
                dao.insert(est);
                response.sendRedirect("Cat");
            } catch (Exception e) {
                System.out.println("Error "+e.getMessage());
            }
  
        } else {
            try {
                dao.update(est);
                response.sendRedirect("Cat");
            } catch (Exception e) {
                System.out.println("Error "+e.getMessage());
            }
  
        }
        
    }


}
