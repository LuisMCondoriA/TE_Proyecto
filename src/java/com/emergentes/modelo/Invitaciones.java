
package com.emergentes.modelo;


public class Invitaciones {
    private int id_inv;
    private int id_usuario;
    private String correo_invitado;
    private int id_cuenta;
    
    private String nombre;
    private String apellido;
    
    private String nombre_cuenta;

    public int getId_inv() {
        return id_inv;
    }

    public void setId_inv(int id_inv) {
        this.id_inv = id_inv;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCorreo_invitado() {
        return correo_invitado;
    }

    public void setCorreo_invitado(String correo_invitado) {
        this.correo_invitado = correo_invitado;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre_cuenta() {
        return nombre_cuenta;
    }

    public void setNombre_cuenta(String nombre_cuenta) {
        this.nombre_cuenta = nombre_cuenta;
    }

    @Override
    public String toString() {
        return "Invitaciones{" + "id_inv=" + id_inv + ", id_usuario=" + id_usuario + ", correo_invitado=" + correo_invitado + ", id_cuenta=" + id_cuenta + ", nombre=" + nombre + ", apellido=" + apellido + ", nombre_cuenta=" + nombre_cuenta + '}';
    }

    
    
}
