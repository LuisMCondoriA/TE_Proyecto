
package com.emergentes.modelo;

public class Bancos {
    private int id;
    private int id_usuario;
    private String descripcion_bancos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getDescripcion_bancos() {
        return descripcion_bancos;
    }

    public void setDescripcion_bancos(String descripcion_bancos) {
        this.descripcion_bancos = descripcion_bancos;
    }

    @Override
    public String toString() {
        return "Bancos{" + "id=" + id + ", id_usuario=" + id_usuario + ", descripcion_bancos=" + descripcion_bancos + '}';
    }


    
    
}
