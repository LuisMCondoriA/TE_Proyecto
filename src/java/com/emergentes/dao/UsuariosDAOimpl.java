
package com.emergentes.dao;

import com.emergentes.modelo.Usuarios;
import com.emergentes.utilies.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UsuariosDAOimpl extends ConexionBD implements UsuariosDAO{
     @Override
    public void insert(Usuarios usuarios) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO usuarios(nombre,apellido,correo,password) values(?,?,?,md5(?))";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, usuarios.getNombre());
            ps.setString(2, usuarios.getApellido());
            ps.setString(3, usuarios.getCorreo());
            ps.setString(4, usuarios.getPassword());

            ps.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Usuarios usuarios) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE usuarios set nombre=?,apellido=?,correo=? where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, usuarios.getNombre());
            ps.setString(2, usuarios.getApellido());
            ps.setString(3, usuarios.getCorreo());
            ps.setInt(4, usuarios.getId());
            
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

        @Override
    public void updateCont(Usuarios usuarios) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE usuarios set password=md5(?) where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, usuarios.getPassword());
            ps.setInt(2, usuarios.getId());
            
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }  

    @Override
    public Usuarios getById(int id) throws Exception {
        Usuarios est = new Usuarios();
        try {
            this.conectar();
            
            String sql = "select * from usuarios where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                est.setId(rs.getInt("id"));
                est.setNombre(rs.getString("nombre"));
                est.setApellido(rs.getString("apellido"));
                est.setCorreo(rs.getString("correo"));
                est.setFecha(rs.getString("fecha"));
                est.setPassword(rs.getString("Password"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return est;
    }

        
    
    public int getusuario(Usuarios usuarios) throws Exception {
        Usuarios est = new Usuarios();
        int r=0;
        try {
            this.conectar();
            
            String sql = "select * from usuarios where correo=? and password=md5(?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, usuarios.getCorreo());
            ps.setString(2, usuarios.getPassword());
            ResultSet rs = ps.executeQuery();
            //era if
            while (rs.next()) {
                r=r+1;
                est.setId(rs.getInt("id"));
                est.setNombre(rs.getString("nombre"));
                est.setApellido(rs.getString("apellido"));
                est.setCorreo(rs.getString("correo"));
                est.setFecha(rs.getString("fecha"));
                est.setPassword(rs.getString("Password"));
                
            }
            if(r==1){
                
                return r;
            }else{
                return 0;
            }
        } catch (Exception e) {
            throw e;
        } finally {
       //     this.desconectar();
        }
       // return r;
    }
    // prueba para obtener todos los datos del usuario
        public Usuarios getusuarioc(String correo) throws Exception {
        Usuarios est = new Usuarios();
        try {
            this.conectar();
            
            String sql = "select * from usuarios where correo=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            //era if
            if (rs.next()) {

                est.setId(rs.getInt("id"));
                est.setNombre(rs.getString("nombre"));
                est.setApellido(rs.getString("apellido"));
                est.setCorreo(rs.getString("correo"));
                est.setFecha(rs.getString("fecha"));
                est.setPassword(rs.getString("Password"));
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return est;
    }
    //fin de prueba
}
