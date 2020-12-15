
package com.emergentes.controlador;

import com.emergentes.dao.BancosDAO;
import com.emergentes.dao.BancosDAOimpl;
import com.emergentes.modelo.Bancos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Bancoss", urlPatterns = {"/Bancoss"})
public class Bancoss extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try {
            BancosDAO dao = new BancosDAOimpl();
            int id;
            Bancos est = new Bancos();
            String action = (request.getParameter("action") != null) ? request.getParameter("action"):"view";
            switch(action){
                case "add":
                    request.setAttribute("bancos", est);
                    request.getRequestDispatcher("frmbancos.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    est = dao.getById(id);
                    request.setAttribute("bancos", est);
                    request.getRequestDispatcher("frmbancos.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Bancoss");
                    break;
                default:
                    id = (int)request.getSession().getAttribute("id");
                    List<Bancos> lista = dao.getAll(id);
                    request.setAttribute("bancos", lista);
                    request.getRequestDispatcher("AdministrarBancos.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        BancosDAO dao = new BancosDAOimpl();
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");

        
        Bancos est = new Bancos();
        est.setId(id);
        est.setDescripcion_bancos(descripcion);
        
        if(id == 0){
            try {
                int id_usuario = (int)request.getSession().getAttribute("id");
                est.setId_usuario(id_usuario);
                dao.insert(est);
                response.sendRedirect("Bancoss");
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
