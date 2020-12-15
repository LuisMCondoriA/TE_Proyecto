
package com.emergentes.modelo;


public class Categorias {
    private int id;
    private int id_usuario;
    private String descripcion;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Categorias{" + "id=" + id + ", id_usuario=" + id_usuario + ", descripcion=" + descripcion + '}';
    }
    
    
}
