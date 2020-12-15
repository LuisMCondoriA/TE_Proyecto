
package com.emergentes.modelo;


public class Movimientos {
    private int id_mov;
    private int cantidad;
    private String tipo;
    private String fecha;
    private int id_categoria;
    private int id_bancos;
    private String descripcion_mov;
    private String fecha_modificacion;
    private int id_cuenta;
    private int id_usuario;
    private int id_usuario_mod;
    
    private String descripcion_bancos;
    private String descripcion;
    
    private String nombre_cuenta;
    
    
    private String nombre;
    private String apellido;
    private String correo;

    
    private int ingreso;
    private int gasto;

    public int getIngreso() {
        return ingreso;
    }

    public void setIngreso(int ingreso) {
        this.ingreso = ingreso;
    }

    public int getGasto() {
        return gasto;
    }

    public void setGasto(int gasto) {
        this.gasto = gasto;
    }
    
    
    public int getId_mov() {
        return id_mov;
    }

    public void setId_mov(int id_mov) {
        this.id_mov = id_mov;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_bancos() {
        return id_bancos;
    }

    public void setId_bancos(int id_bancos) {
        this.id_bancos = id_bancos;
    }

    public String getDescripcion_mov() {
        return descripcion_mov;
    }

    public void setDescripcion_mov(String descripcion_mov) {
        this.descripcion_mov = descripcion_mov;
    }

    public String getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(String fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_usuario_mod() {
        return id_usuario_mod;
    }

    public void setId_usuario_mod(int id_usuario_mod) {
        this.id_usuario_mod = id_usuario_mod;
    }

    public String getDescripcion_bancos() {
        return descripcion_bancos;
    }

    public void setDescripcion_bancos(String descripcion_bancos) {
        this.descripcion_bancos = descripcion_bancos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre_cuenta() {
        return nombre_cuenta;
    }

    public void setNombre_cuenta(String nombre_cuenta) {
        this.nombre_cuenta = nombre_cuenta;
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

    @Override
    public String toString() {
        return "Movimientos{" + "id_mov=" + id_mov + ", cantidad=" + cantidad + ", tipo=" + tipo + ", fecha=" + fecha + ", id_categoria=" + id_categoria + ", id_bancos=" + id_bancos + ", descripcion_mov=" + descripcion_mov + ", fecha_modificacion=" + fecha_modificacion + ", id_cuenta=" + id_cuenta + ", id_usuario=" + id_usuario + ", id_usuario_mod=" + id_usuario_mod + ", descripcion_bancos=" + descripcion_bancos + ", descripcion=" + descripcion + ", nombre_cuenta=" + nombre_cuenta + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", ingreso=" + ingreso + ", gasto=" + gasto + '}';
    }


    
}
