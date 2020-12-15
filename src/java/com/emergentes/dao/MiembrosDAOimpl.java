
package com.emergentes.dao;

import com.emergentes.modelo.Miembros;
import com.emergentes.utilies.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MiembrosDAOimpl extends ConexionBD implements MiembrosDAO{
    @Override
    
    public void insert(Miembros miembros) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO miembros (id_cuenta,id_usuario_m) values(?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, miembros.getId_cuenta());
            ps.setInt(2, miembros.getId_usuario_m());

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
            String sql = "DELETE from miembros where id_m=?";
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
    public List<Miembros> getAll(int id) throws Exception {
        List<Miembros> lista = null;
        try {
            this.conectar();
            String sql = "select * from miembros m INNER JOIN cuentas c ON m.id_cuenta=c.id INNER JOIN usuarios u ON c.id_propietario=u.id and m.id_usuario_m=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Miembros>();
            while(rs.next()){
                Miembros est = new Miembros();
                est.setId_m(rs.getInt("id_m"));
                est.setId_cuenta(rs.getInt("id_cuenta"));
                est.setId_usuario_m(rs.getInt("id_usuario_m"));
                est.setNombre_cuenta(rs.getString("nombre_cuenta"));
                est.setNombre(rs.getString("nombre"));
                est.setApellido(rs.getString("apellido"));
                est.setCorreo(rs.getString("correo"));
                est.setFecha_ingreso(rs.getString("fecha_ingreso"));
                lista.add(est);
            }
        } catch (Exception e) {
            throw e;
        } finally {
         //   this.desconectar();
        }
        return lista;
    }
    
    @Override
    public List<Miembros> getAllmiembros(int id) throws Exception {
        List<Miembros> lista = null;
        try {
            this.conectar();
            String sql = "select * from miembros m INNER JOIN cuentas c ON m.id_cuenta=c.id INNER JOIN usuarios u ON m.id_usuario_m=u.id and id_propietario=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Miembros>();
            while(rs.next()){
                Miembros est = new Miembros();
                est.setId_m(rs.getInt("id_m"));
                est.setId_cuenta(rs.getInt("id_cuenta"));
                est.setId_usuario_m(rs.getInt("id_usuario_m"));
                est.setNombre_cuenta(rs.getString("nombre_cuenta"));
                est.setNombre(rs.getString("nombre"));
                est.setApellido(rs.getString("apellido"));
                est.setCorreo(rs.getString("correo"));
                est.setFecha_ingreso(rs.getString("fecha_ingreso"));
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
    public List<Miembros> getAllm(int id) throws Exception {
        List<Miembros> lista = null;
        try {
            this.conectar();
            String sql = "select * from miembros m INNER JOIN cuentas c ON m.id_cuenta=c.id INNER JOIN usuarios u ON m.id_usuario_m=u.id";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Miembros>();
            while(rs.next()){
                Miembros est = new Miembros();
                est.setId_m(rs.getInt("id_m"));
                est.setId_cuenta(rs.getInt("id_cuenta"));
                est.setId_usuario_m(rs.getInt("id_usuario_m"));
                est.setNombre_cuenta(rs.getString("nombre_cuenta"));
                est.setNombre(rs.getString("nombre"));
                est.setApellido(rs.getString("apellido"));
                est.setCorreo(rs.getString("correo"));
                est.setFecha_ingreso(rs.getString("fecha_ingreso"));
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
