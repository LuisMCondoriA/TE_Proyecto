
package com.emergentes.dao;

import com.emergentes.modelo.Bancos;
import com.emergentes.utilies.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BancosDAOimpl extends ConexionBD implements BancosDAO{
        @Override
    public void insert(Bancos bancos) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO bancos (id_usuario,descripcion_bancos) values(?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, bancos.getId_usuario());
            ps.setString(2, bancos.getDescripcion_bancos());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Bancos bancos) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE bancos set descripcion_bancos=? where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, bancos.getDescripcion_bancos());
            ps.setInt(2, bancos.getId());
            
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
            String sql = "DELETE from bancos where id=?";
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
    public Bancos getById(int id) throws Exception {
        Bancos est = new Bancos();
        try {
            this.conectar();
            
            String sql = "select * from bancos where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                est.setId(rs.getInt("id"));
                est.setId_usuario(rs.getInt("id_usuario"));
                est.setDescripcion_bancos(rs.getString("descripcion_bancos"));
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return est;
    }

    @Override
    public List<Bancos> getAll(int id) throws Exception {
        List<Bancos> lista = null;
        try {
            this.conectar();
            String sql = "select * from bancos where id_usuario=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Bancos>();
            while(rs.next()){
                Bancos est = new Bancos();
                est.setId(rs.getInt("id"));
                est.setId_usuario(rs.getInt("id_usuario"));
                est.setDescripcion_bancos(rs.getString("descripcion_bancos"));
                
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
