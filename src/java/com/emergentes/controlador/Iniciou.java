
package com.emergentes.controlador;

import com.emergentes.dao.UsuariosDAO;
import com.emergentes.dao.UsuariosDAOimpl;
import com.emergentes.modelo.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Iniciou", urlPatterns = {"/Iniciou"})
public class Iniciou extends HttpServlet {



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
                
                default:
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
        int r;
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        Usuarios est = new Usuarios();
        est.setCorreo(correo);
        est.setPassword(password);        
        try {
            r=dao.getusuario(est);
            est=dao.getusuarioc(correo);
            if (r==1){            
                request.getSession().setAttribute("correo", correo);
                request.getSession().setAttribute("id", est.getId());
                request.getSession().setAttribute("nombre", est.getNombre());
                request.getSession().setAttribute("apellido", est.getApellido());
                request.getSession().setAttribute("fecha", est.getFecha());
                request.getSession().setAttribute("password", est.getPassword());
                request.getRequestDispatcher("PaginaPrincipal.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("iniciarsesion.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(Iniciou.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
    }
    
}
