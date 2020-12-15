
package com.emergentes.controlador;

import com.emergentes.dao.InvitacionesDAO;
import com.emergentes.dao.InvitacionesDAOimpl;
import com.emergentes.dao.MiembrosDAO;
import com.emergentes.dao.MiembrosDAOimpl;
import com.emergentes.modelo.Miembros;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Miembross", urlPatterns = {"/Miembross"})
public class Miembross extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                try {
            MiembrosDAO dao = new MiembrosDAOimpl();
            InvitacionesDAO dao2 = new InvitacionesDAOimpl();
            int id;
            int id_usuario_m,id_inv;
            String correo;
            Miembros est = new Miembros();
            String action = (request.getParameter("action") != null) ? request.getParameter("action"):"view";
            switch(action){
                case "add":
                    
                    id = Integer.parseInt(request.getParameter("id_cuenta"));
                    id_inv = Integer.parseInt(request.getParameter("id_inv"));
                    id_usuario_m = (int)request.getSession().getAttribute("id");
                    est.setId_cuenta(id);
                    est.setId_usuario_m(id_usuario_m);
                    try{
                        dao.insert(est);
                        dao2.delete(id_inv);
                        response.sendRedirect("Cuentass");
                    } catch (Exception e){
                        System.out.println("Error "+e.getMessage());
                    }                    
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Invitacioness");
                    break;    
            }
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
    }
}
