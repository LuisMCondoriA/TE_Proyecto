
package com.emergentes.controlador;

import com.emergentes.dao.BancosDAO;
import com.emergentes.dao.BancosDAOimpl;
import com.emergentes.dao.CategoriasDAO;
import com.emergentes.dao.CategoriasDAOimpl;
import com.emergentes.dao.CuentasDAO;
import com.emergentes.dao.CuentasDAOimpl;
import com.emergentes.dao.MovimientosDAO;
import com.emergentes.dao.MovimientosDAOimpl;
import com.emergentes.modelo.Bancos;
import com.emergentes.modelo.Categorias;
import com.emergentes.modelo.Cuentas;
import com.emergentes.modelo.Movimientos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Movimientoss", urlPatterns = {"/Movimientoss"})
public class Movimientoss extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                        try {
            MovimientosDAO dao = new MovimientosDAOimpl();
            CuentasDAO dao2 = new CuentasDAOimpl();
            BancosDAO daob = new BancosDAOimpl();
            CategoriasDAO daoc = new CategoriasDAOimpl();
            int id;
            int id_cuenta;
            int idu;
            int id_propietario;
            Movimientos est = new Movimientos();
            Movimientos saldo = new Movimientos();
            Movimientos estmod = new Movimientos();
            Cuentas est2 = new Cuentas();
            String action = (request.getParameter("action") != null) ? request.getParameter("action"):"view";
            switch(action){
                case "add":
                    id = Integer.parseInt(request.getParameter("id_cuenta"));
                    est2 = dao2.getById(id);
                    idu = (int)request.getSession().getAttribute("id");
                    id_propietario = Integer.parseInt(request.getParameter("id_propietario"));
                    List<Bancos> lista2 = daob.getAll(id_propietario);
                    List<Categorias> lista3 = daoc.getAll(id_propietario);
                    
                    request.setAttribute("movimientos", est);
                    request.setAttribute("cuentas", est2);
                    request.setAttribute("bancos", lista2);
                    request.setAttribute("categorias", lista3);
                    request.getRequestDispatcher("frmmovimientos.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id_mov"));
                    est = dao.getById(id);                   
                    id_cuenta = Integer.parseInt(request.getParameter("id_cuenta"));
                    est2 = dao2.getById(id_cuenta);
                    id_propietario = Integer.parseInt(request.getParameter("id_propietario"));
                    List<Bancos> listaa = daob.getAll(id_propietario);
                    List<Categorias> listab = daoc.getAll(id_propietario);
                    request.setAttribute("cuentas", est2);
                    request.setAttribute("bancos", listaa);
                    request.setAttribute("categorias", listab);               
                    request.setAttribute("movimientos", est);
                    request.getRequestDispatcher("frmmovimientos.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    id_cuenta = Integer.parseInt(request.getParameter("id_cuenta"));                   
                    saldo = dao.saldo(id_cuenta);                   
                    List<Movimientos> listamof = dao.getAll(id_cuenta);
                    est2 = dao2.getById(id_cuenta);
                    request.setAttribute("movimientos", listamof);
                    request.setAttribute("cuentas", est2);                   
                    request.setAttribute("saldo", saldo);
                    request.getRequestDispatcher("AdministrarMovimientos.jsp").forward(request, response);
                    break;
                case "detalles":
                    id = Integer.parseInt(request.getParameter("id"));
                    id_cuenta = Integer.parseInt(request.getParameter("id_cuenta"));
                    est = dao.getById(id);
                    estmod = dao.getUsmod(id);
                    est2 = dao2.getById(id_cuenta);                   
                    request.setAttribute("cuentas", est2);
                    request.setAttribute("movimientos", est);
                    request.setAttribute("usuariomov", estmod);
                    request.getRequestDispatcher("detalles.jsp").forward(request, response);
                    break;                                          
                default:
                    id_cuenta = Integer.parseInt(request.getParameter("id"));                                    
                    List<Movimientos> lista = dao.getAll(id_cuenta);
                    est2 = dao2.getById(id_cuenta);                   
                    saldo = dao.saldo(id_cuenta);                                                          
                    request.setAttribute("movimientos", lista);
                    request.setAttribute("cuentas", est2);
                    request.setAttribute("saldo", saldo);
                    request.getRequestDispatcher("AdministrarMovimientos.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        MovimientosDAO dao = new MovimientosDAOimpl();
        CuentasDAO dao2 = new CuentasDAOimpl();
        BancosDAO dao3 = new BancosDAOimpl();
        CategoriasDAO dao4 = new CategoriasDAOimpl();
        
        int id_mov = Integer.parseInt(request.getParameter("id_mov"));
        int id_usuario_mod = (int)request.getSession().getAttribute("id");
        int id_cuenta = Integer.parseInt(request.getParameter("id_cuenta"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String tipo = request.getParameter("tipo");
        String fecha = request.getParameter("fecha");
        int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
        int id_bancos = Integer.parseInt(request.getParameter("id_bancos"));
        String descripcion_mov = request.getParameter("descripcion_mov");                    
        Cuentas est2 = new Cuentas();
        Movimientos est = new Movimientos();
        Bancos est3 = new Bancos();
        Categorias est4 = new Categorias();        
        est.setId_mov(id_mov);
        est.setCantidad(cantidad);
        est.setTipo(tipo);
        est.setFecha(fecha);
        est.setId_categoria(id_categoria);
        est.setId_bancos(id_bancos);
        est.setDescripcion_mov(descripcion_mov);
        est.setId_cuenta(id_cuenta);
        est.setId_usuario(id_usuario_mod);
        est.setId_usuario_mod(id_usuario_mod);             
        if(id_mov == 0){
        try {               
                dao.insert(est);
                est2 = dao2.getById(id_cuenta);
                est3 = dao3.getById(id_bancos);
                est4 = dao4.getById(id_categoria);
                request.setAttribute("cuentas", est2);
                request.setAttribute("movimientou", est);
                request.setAttribute("categorias", est4);
                request.setAttribute("bancos", est3);
                request.getRequestDispatcher("Mensajemov.jsp").forward(request, response);
            } catch (Exception e) {
                System.out.println("Error "+e.getMessage());
            }       
        } else {
            try {
                dao.update(est);
                est2 = dao2.getById(id_cuenta);
                est3 = dao3.getById(id_bancos);
                est4 = dao4.getById(id_categoria);
                request.setAttribute("cuentas", est2);
                request.setAttribute("movimientou", est);
                request.setAttribute("categorias", est4);
                request.setAttribute("bancos", est3);
                request.getRequestDispatcher("Mensajemov.jsp").forward(request, response);
            } catch (Exception e) {
                System.out.println("Error "+e.getMessage());
            }
  
        }
    }

}
