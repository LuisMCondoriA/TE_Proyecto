
package com.emergentes.controlador;

import com.emergentes.dao.UsuariosDAO;
import com.emergentes.dao.UsuariosDAOimpl;
import com.emergentes.modelo.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Crearu", urlPatterns = {"/Crearu"})
public class Crearu extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                       try {
            UsuariosDAO dao = new UsuariosDAOimpl();
            int id;
            Usuarios est = new Usuarios();
            String action = (request.getParameter("action") != null) ? request.getParameter("action"):"view";
            switch(action){
                case "add":
                    request.setAttribute("usuario", est);
                    request.getRequestDispatcher("frmusuarios.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    est = dao.getById(id);
                    request.setAttribute("usuario", est);
                    request.getRequestDispatcher("frmusuarios.jsp").forward(request, response);
                    break;
                
                case "close":
                    request.getSession().invalidate();    
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;    

            }
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuariosDAO dao = new UsuariosDAOimpl();
        int id = Integer.parseInt(request.getParameter("id"));
        String fecha = request.getParameter("fecha");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String password = request.getParameter("contra");
        int aux = Integer.parseInt(request.getParameter("aux"));
        
        
        Usuarios est = new Usuarios();
        est.setId(id);
        est.setNombre(nombre);
        est.setApellido(apellido);
        est.setCorreo(correo);
        est.setPassword(password);
        
        if(id == 0){
            try {
                dao.insert(est);
                response.sendRedirect("iniciarsesion.jsp");
            } catch (Exception e) {
                System.out.println("Error "+e.getMessage());
            }
  
        } else {
            if(aux==1){
                 try {
                dao.update(est);
                request.getSession().invalidate();
                request.getSession().setAttribute("id", id);
                request.getSession().setAttribute("nombre", nombre);
                request.getSession().setAttribute("apellido", apellido);
                request.getSession().setAttribute("correo", correo);
                request.getSession().setAttribute("fecha", fecha);
                
                response.sendRedirect("PaginaPrincipal.jsp");
            } catch (Exception e) {
                System.out.println("Error "+e.getMessage());
            }
            }else{
                try {
                dao.updateCont(est);
                request.getSession().invalidate();
                request.getSession().setAttribute("id", id);
                request.getSession().setAttribute("nombre", nombre);
                request.getSession().setAttribute("apellido", apellido);
                request.getSession().setAttribute("correo", correo);
                request.getSession().setAttribute("fecha", fecha);
               
                response.sendRedirect("PaginaPrincipal.jsp");
            } catch (Exception e) {
                System.out.println("Error "+e.getMessage());
            }
            }      
        }

    }

}
