
package com.emergentes.dao;

import com.emergentes.modelo.Usuarios;
import java.util.List;


public interface UsuariosDAO {
    public void insert(Usuarios usuarios) throws Exception;
    public void update(Usuarios usuarios) throws Exception;
    public void updateCont(Usuarios usuarios) throws Exception;
    
    public Usuarios getById(int id) throws Exception;
    public Usuarios getusuarioc(String correo) throws Exception;
    public int getusuario(Usuarios usuarios) throws Exception;  
    
}
