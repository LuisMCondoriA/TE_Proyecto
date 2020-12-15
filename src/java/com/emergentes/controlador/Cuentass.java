
package com.emergentes.controlador;

import com.emergentes.dao.CuentasDAO;
import com.emergentes.dao.CuentasDAOimpl;
import com.emergentes.dao.MiembrosDAO;
import com.emergentes.dao.MiembrosDAOimpl;
import com.emergentes.modelo.Cuentas;
import com.emergentes.modelo.Miembros;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Cuentass", urlPatterns = {"/Cuentass"})
public class Cuentass extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                     try {
            CuentasDAO dao = new CuentasDAOimpl();
            MiembrosDAO dao2 = new MiembrosDAOimpl();
            int id;
            Cuentas est = new Cuentas();
            String action = (request.getParameter("action") != null) ? request.getParameter("action"):"view";
            switch(action){
                case "add":
                    request.setAttribute("cuentas", est);
                    request.getRequestDispatcher("frmcuentas.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    est = dao.getById(id);
                    request.setAttribute("cuentas", est);
                    request.getRequestDispatcher("frmcuentas.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Cuentass");
                    break;
                default:
                    id = (int)request.getSession().getAttribute("id");
                    List<Cuentas> lista = dao.getAll(id);
                    List<Miembros> lista2 = dao2.getAll(id);
                    List<Miembros> lista3 = dao2.getAllm(id);
                    request.setAttribute("cuentas", lista);
                    request.setAttribute("miembros", lista2);
                    request.setAttribute("miembrosall", lista3);
                    request.getRequestDispatcher("AdministrarCuentas.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }   
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CuentasDAO dao = new CuentasDAOimpl();
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre_cuenta = request.getParameter("nombre_cuenta");

        
        Cuentas est = new Cuentas();
        est.setId(id);
        est.setNombre_cuenta(nombre_cuenta);
        
        if(id == 0){
            try {
                int id_propietario = (int)request.getSession().getAttribute("id");
                est.setId_propietario(id_propietario);
                dao.insert(est);               
                response.sendRedirect("Cuentass");
            } catch (Exception e) {
                System.out.println("Error "+e.getMessage());
            }
  
        } else {
            try {
                dao.update(est);
                response.sendRedirect("Cuentass");
            } catch (Exception e) {
                System.out.println("Error "+e.getMessage());
            }  
        }     
    }       
    }


