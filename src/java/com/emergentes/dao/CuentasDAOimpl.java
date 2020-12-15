
package com.emergentes.dao;

import com.emergentes.modelo.Cuentas;
import com.emergentes.utilies.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CuentasDAOimpl extends ConexionBD implements CuentasDAO{
     @Override
    public void insert(Cuentas cuentas) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO cuentas (nombre_cuenta,fecha_creacion,id_propietario,fecha_modificacion) values(?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cuentas.getNombre_cuenta());
            ps.setString(2, cuentas.getFecha_creacion());
            ps.setInt(3, cuentas.getId_propietario());
            ps.setString(4, cuentas.getFecha_modificacion());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Cuentas cuentas) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE cuentas set nombre_cuenta=? where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cuentas.getNombre_cuenta());
            ps.setInt(2, cuentas.getId());
            
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
            String sql = "DELETE from cuentas where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }
    

    @Override
    public Cuentas getById(int id) throws Exception {
        Cuentas est = new Cuentas();
        try {
            this.conectar();
            
            String sql = "select * from cuentas c INNER JOIN usuarios u ON c.id_propietario=u.id where c.id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                est.setId(rs.getInt("id"));
                est.setNombre_cuenta(rs.getString("nombre_cuenta"));
                est.setFecha_creacion(rs.getString("fecha_creacion"));
                est.setId_propietario(rs.getInt("id_propietario"));
                est.setFecha_modificacion(rs.getString("fecha_modificacion"));
                est.setNombre(rs.getString("nombre"));
                est.setApellido(rs.getString("apellido"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return est;
    }

    @Override
    public List<Cuentas> getAll(int id) throws Exception {
        List<Cuentas> lista = null;
        try {
            this.conectar();
            String sql = "select * from cuentas where id_propietario=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Cuentas>();
            while(rs.next()){
                Cuentas est = new Cuentas();
                est.setId(rs.getInt("id"));
                est.setNombre_cuenta(rs.getString("nombre_cuenta"));
                est.setFecha_creacion(rs.getString("fecha_creacion"));
                est.setId_propietario(rs.getInt("id_propietario"));
                est.setFecha_modificacion(rs.getString("fecha_modificacion"));
                
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
