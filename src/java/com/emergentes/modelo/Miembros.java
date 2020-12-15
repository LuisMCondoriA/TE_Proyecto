
package com.emergentes.modelo;


public class Miembros {
    private int id_m;
    private int id_cuenta;
    private int id_usuario_m;
    private String fecha_ingreso;
    private String nombre;
    private String apellido;
    private String correo;
    private String nombre_cuenta;
    
    public int getId_m() {
        return id_m;
    }

    public void setId_m(int id_m) {
        this.id_m = id_m;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public int getId_usuario_m() {
        return id_usuario_m;
    }

    public void setId_usuario_m(int id_usuario_m) {
        this.id_usuario_m = id_usuario_m;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre_cuenta() {
        return nombre_cuenta;
    }

    public void setNombre_cuenta(String nombre_cuenta) {
        this.nombre_cuenta = nombre_cuenta;
    }

    @Override
    public String toString() {
        return "Miembros{" + "id_m=" + id_m + ", id_cuenta=" + id_cuenta + ", id_usuario_m=" + id_usuario_m + ", fecha_ingreso=" + fecha_ingreso + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", nombre_cuenta=" + nombre_cuenta + '}';
    }


    
    
}
