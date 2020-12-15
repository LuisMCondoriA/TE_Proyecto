
package com.emergentes.dao;

import com.emergentes.modelo.Invitaciones;
import java.util.List;


public interface InvitacionesDAO {
    public void insert(Invitaciones invitaciones) throws Exception;
    public void update(Invitaciones invitaciones) throws Exception;
    public void delete(int id) throws Exception;
    public Invitaciones getById(int id) throws Exception;  
    public List<Invitaciones> getAll(String correo_invitado) throws Exception;
    public List<Invitaciones> getAllinv(int id) throws Exception;
    public List<Invitaciones> getmisinv(String correo) throws Exception;
}
