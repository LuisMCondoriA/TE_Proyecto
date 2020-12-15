
package com.emergentes.dao;

import com.emergentes.modelo.Movimientos;
import com.emergentes.utilies.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MovimientosDAOimpl extends ConexionBD implements MovimientosDAO{
     @Override
    public void insert(Movimientos movimientos) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO movimientos (cantidad,tipo,fecha,id_categoria,id_bancos,descripcion_mov,id_cuenta,id_usuario,id_usuario_mod) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, movimientos.getCantidad());
            ps.setString(2, movimientos.getTipo());
            ps.setString(3, movimientos.getFecha());
            ps.setInt(4, movimientos.getId_categoria());
            ps.setInt(5, movimientos.getId_bancos());
            ps.setString(6, movimientos.getDescripcion_mov());
            ps.setInt(7, movimientos.getId_cuenta());
            ps.setInt(8, movimientos.getId_usuario_mod());
            ps.setInt(9, movimientos.getId_usuario_mod());
            
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

   
    @Override
    public Movimientos saldo(int id) throws Exception {
        Movimientos est = new Movimientos();
        try {
            this.conectar();
            String sql = "SELECT sum(cantidad) from movimientos WHERE tipo='Ingreso' AND id_cuenta=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();     
            if (rs.next()) {
                est.setIngreso(rs.getInt("sum(cantidad)"));
            }
            String sql2 = "SELECT sum(cantidad) from movimientos WHERE tipo='Gasto' AND id_cuenta=?";
            PreparedStatement ps2 = this.conn.prepareStatement(sql2);
            ps2.setInt(1, id);
            ResultSet rs2 = ps2.executeQuery();
            if (rs2.next()) {
                est.setGasto(rs2.getInt("sum(cantidad)"));
            }
            
            
        } catch (Exception e) {
            throw e;
        } finally {
          //  this.desconectar();
        }
        return est;
    }
    
    
    @Override
    public void update(Movimientos movimientos) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE movimientos set cantidad=?,tipo=?,fecha=?,id_categoria=?,id_bancos=?,descripcion_mov=?,id_usuario_mod=? where id_mov=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, movimientos.getCantidad());
            ps.setString(2, movimientos.getTipo());
            ps.setString(3, movimientos.getFecha());
            ps.setInt(4, movimientos.getId_categoria());
            ps.setInt(5, movimientos.getId_bancos());
            ps.setString(6, movimientos.getDescripcion_mov());
            ps.setInt(7, movimientos.getId_usuario_mod());
            ps.setInt(8, movimientos.getId_mov());
            
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
            String sql = "DELETE from movimientos where id_mov=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
       //     this.desconectar();
        }
    }
    

    @Override
    public Movimientos getById(int id) throws Exception {
        Movimientos est = new Movimientos();
        try {
            this.conectar();
            String sql = "select * from movimientos m INNER JOIN bancos b ON m.id_bancos=b.id INNER JOIN categorias c ON m.id_categoria=c.id INNER JOIN usuarios u ON m.id_usuario=u.id where id_mov=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                est.setId_mov(rs.getInt("id_mov"));
                est.setCantidad(rs.getInt("cantidad"));
                est.setTipo(rs.getString("tipo"));
                est.setFecha(rs.getString("fecha"));
                est.setId_categoria(rs.getInt("id_categoria"));
                est.setId_bancos(rs.getInt("id_bancos"));
                est.setDescripcion_mov(rs.getString("descripcion_mov"));
                est.setFecha_modificacion(rs.getString("fecha_modificacion"));
                est.setId_cuenta(rs.getInt("id_cuenta"));
                est.setId_usuario(rs.getInt("id_usuario")); 
                est.setId_usuario_mod(rs.getInt("id_usuario_mod"));
                est.setDescripcion(rs.getString("descripcion"));
                est.setDescripcion_bancos(rs.getString("descripcion_bancos"));
                est.setNombre(rs.getString("nombre"));
                est.setApellido(rs.getString("apellido"));
            }
            
            
        } catch (Exception e) {
            throw e;
        } finally {
          //  this.desconectar();
        }
        return est;
    }

    
        @Override
    public Movimientos getUsmod(int id) throws Exception {
        Movimientos est = new Movimientos();
        try {
            this.conectar();
            String sql = "select * from movimientos m INNER JOIN usuarios u ON m.id_usuario_mod=u.id where id_mov=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                est.setFecha_modificacion(rs.getString("fecha_modificacion"));
                 
                est.setId_usuario_mod(rs.getInt("id_usuario_mod"));
                
               
                est.setNombre(rs.getString("nombre"));
                est.setApellido(rs.getString("apellido"));
                est.setCorreo(rs.getString("correo"));
            }
            
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return est;
    }
    
    
    
    @Override
    public List<Movimientos> getAll(int id) throws Exception {
        List<Movimientos> lista = null;
        try {
            this.conectar();
            String sql = "select * from movimientos m INNER JOIN cuentas c ON m.id_cuenta=c.id INNER JOIN usuarios u ON m.id_usuario=u.id INNER JOIN categorias ca ON ca.id=m.id_categoria INNER JOIN bancos b ON b.id=m.id_bancos and id_cuenta=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Movimientos>();
            while(rs.next()){
                Movimientos est = new Movimientos();
                est.setId_mov(rs.getInt("id_mov"));
                est.setCantidad(rs.getInt("cantidad"));
                est.setTipo(rs.getString("tipo"));
                est.setFecha(rs.getString("fecha"));
                est.setDescripcion(rs.getString("descripcion"));
                est.setDescripcion_bancos(rs.getString("descripcion_bancos"));
                est.setNombre(rs.getString("nombre"));
                est.setApellido(rs.getString("apellido"));
                est.setNombre_cuenta(rs.getString("nombre_cuenta"));
                est.setDescripcion_mov(rs.getString("descripcion_mov"));
                
                lista.add(est);
            }
        } catch (Exception e) {
            throw e;
        } finally {
         //   this.desconectar();
        }
        return lista;
    }
}
