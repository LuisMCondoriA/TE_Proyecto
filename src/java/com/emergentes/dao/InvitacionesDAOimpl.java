
package com.emergentes.dao;

import com.emergentes.modelo.Invitaciones;
import com.emergentes.utilies.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class InvitacionesDAOimpl extends ConexionBD implements InvitacionesDAO{
     @Override
    public void insert(Invitaciones invitaciones) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO invitaciones (id_usuario,correo_invitado,id_cuenta) values(?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, invitaciones.getId_usuario());
            ps.setString(2, invitaciones.getCorreo_invitado());
            ps.setInt(3, invitaciones.getId_cuenta());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Invitaciones invitaciones) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE invitaciones set correo_invitado=? where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, invitaciones.getCorreo_invitado());
        //    ps.setInt(2, invitaciones.getId());
            
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE from invitaciones where id_inv=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
         //   this.desconectar();
        }
    }
    

    @Override
    public Invitaciones getById(int id) throws Exception {
        Invitaciones est = new Invitaciones();
        try {
            this.conectar();
            est.setId_cuenta(id);
        /*    String sql = "select * from cuentas where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                est.setId(rs.getInt("id"));
                est.setId_usuario(rs.getInt("id_usuario"));
                est.setCorreo_invitado(rs.getString("correo_invitado"));
                est.setId_cuenta(rs.getInt("id_cuenta"));
            }*/
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return est;
    }

    @Override
    public List<Invitaciones> getmisinv(String correo) throws Exception {
        List<Invitaciones> lista2 = null;
        try {
            this.conectar();
            String sql = "select * from invitaciones i,usuarios u,cuentas c where i.id_usuario=u.id and i.id_cuenta=c.id and  i.correo_invitado=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            lista2 = new ArrayList<Invitaciones>();
            while(rs.next()){
                Invitaciones est = new Invitaciones();
                est.setId_inv(rs.getInt("id_inv"));
                est.setId_cuenta(rs.getInt("id_cuenta"));
                est.setId_usuario(rs.getInt("id_usuario"));
                est.setCorreo_invitado(rs.getString("correo_invitado"));
                est.setNombre(rs.getString("nombre"));
                est.setApellido(rs.getString("apellido"));
                est.setNombre_cuenta(rs.getString("nombre_cuenta"));
                
                
                lista2.add(est);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista2;
    }
    
    
    @Override
    public List<Invitaciones> getAll(String correo_invitado) throws Exception {
        List<Invitaciones> lista = null;
        try {
            this.conectar();
            String sql = "select * from invitaciones i,usuarios u,cuentas c where i.id_usuario=u.id and i.id_cuenta=c.id and  i.correo_invitado=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, correo_invitado);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Invitaciones>();
            while(rs.next()){
                Invitaciones est = new Invitaciones();
                est.setId_inv(rs.getInt("id_inv"));
                est.setId_usuario(rs.getInt("id_usuario"));
                est.setCorreo_invitado(rs.getString("correo_invitado"));
                est.setNombre(rs.getString("nombre"));
                est.setApellido(rs.getString("apellido"));
                est.setNombre_cuenta(rs.getString("nombre_cuenta"));
                
                lista.add(est);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
        @Override
    public List<Invitaciones> getAllinv(int id) throws Exception {
        List<Invitaciones> lista = null;
        try {
            this.conectar();
            String sql = "select * from invitaciones i,cuentas c where i.id_cuenta=c.id and id_usuario=?";
            //select * from invitaciones i,usuarios u,cuentas c where i.id_usuario=u.id and i.id_cuenta=c.id and  i.correo_invitado=?
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Invitaciones>();
            while(rs.next()){
                Invitaciones est = new Invitaciones();
                est.setId_inv(rs.getInt("id_inv"));
                est.setId_usuario(rs.getInt("id_usuario"));
                est.setCorreo_invitado(rs.getString("correo_invitado"));
                est.setNombre_cuenta(rs.getString("nombre_cuenta"));
                
                lista.add(est);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
}
