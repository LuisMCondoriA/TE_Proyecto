
package com.emergentes.dao;

import com.emergentes.modelo.Categorias;
import com.emergentes.utilies.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriasDAOimpl extends ConexionBD implements CategoriasDAO{
    @Override
    public void insert(Categorias categorias) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO categorias (id_usuario,descripcion) values(?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, categorias.getId_usuario());
            ps.setString(2, categorias.getDescripcion());

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Categorias categorias) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE categorias set descripcion=? where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, categorias.getDescripcion());
            ps.setInt(2, categorias.getId());
            
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
            String sql = "DELETE from categorias where id=?";
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
    public Categorias getById(int id) throws Exception {
        Categorias est = new Categorias();
        try {
            this.conectar();
            
            String sql = "select * from categorias where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                est.setId(rs.getInt("id"));
                est.setId_usuario(rs.getInt("id_usuario"));
                est.setDescripcion(rs.getString("descripcion"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return est;
    }

    @Override
    public List<Categorias> getAll(int id) throws Exception {
        List<Categorias> lista = null;
        try {
            this.conectar();
            String sql = "select * from categorias where id_usuario=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Categorias>();
            while(rs.next()){
                Categorias est = new Categorias();
                est.setId(rs.getInt("id"));
                est.setId_usuario(rs.getInt("id_usuario"));
                est.setDescripcion(rs.getString("descripcion"));
                
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
