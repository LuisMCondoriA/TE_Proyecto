
package com.emergentes.controlador;

import com.emergentes.dao.InvitacionesDAO;
import com.emergentes.dao.InvitacionesDAOimpl;
import com.emergentes.dao.MiembrosDAO;
import com.emergentes.dao.MiembrosDAOimpl;
import com.emergentes.modelo.Invitaciones;
import com.emergentes.modelo.Miembros;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Invitacioness", urlPatterns = {"/Invitacioness"})
public class Invitacioness extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            InvitacionesDAO dao = new InvitacionesDAOimpl();
            MiembrosDAO dao2 = new MiembrosDAOimpl();
            int id;          
            String correo;
            Invitaciones est = new Invitaciones();
            String action = (request.getParameter("action") != null) ? request.getParameter("action"):"view";
            switch(action){
                case "add":
                    id = Integer.parseInt(request.getParameter("id"));
                    est = dao.getById(id);
                    request.setAttribute("invitaciones", est);
                    request.getRequestDispatcher("frminvitaciones.jsp").forward(request, response);
                    break;
                
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Invitacioness");
                    break; 
                case "deleteinv":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);                   
                    correo = (String)request.getSession().getAttribute("correo");
                    List<Invitaciones> lista3 = dao.getmisinv(correo);
                    request.setAttribute("invitaciones2", lista3);
                    request.getRequestDispatcher("Buzon.jsp").forward(request, response);
                   
                    break; 
                    
                case "misinv":
                    correo = (String)request.getSession().getAttribute("correo");
                    List<Invitaciones> lista2 = dao.getmisinv(correo);
                    request.setAttribute("invitaciones2", lista2);
                    request.getRequestDispatcher("Buzon.jsp").forward(request, response);
                    break;    
                    
                default:
                    id = (int)request.getSession().getAttribute("id");
                    List<Invitaciones> lista = dao.getAllinv(id);
                    List<Miembros> lista4 = dao2.getAllmiembros(id);
                    request.setAttribute("invitaciones", lista);
                    request.setAttribute("miembros", lista4);
                    request.getRequestDispatcher("AdministrarInv.jsp").forward(request, response);
                    break; 
            }
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         InvitacionesDAO dao = new InvitacionesDAOimpl();
        int id = Integer.parseInt(request.getParameter("id"));
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        int id_cuenta = Integer.parseInt(request.getParameter("id_cuenta"));       
        String correo_invitado = request.getParameter("correo_invitado");       
        Invitaciones est = new Invitaciones();
        est.setId_usuario(id_usuario);
        est.setId_cuenta(id_cuenta);       
        est.setCorreo_invitado(correo_invitado);
        
        if(id == 0){
            try {
                
                dao.insert(est);
                response.sendRedirect("Cuentass");
            } catch (Exception e) {
                System.out.println("Error "+e.getMessage());
            }  
        } else {
            try {
                dao.update(est);
                response.sendRedirect("Bancoss");
            } catch (Exception e) {
                System.out.println("Error "+e.getMessage());
            }  
        }       
    }

}
