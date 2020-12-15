
package com.emergentes.dao;

import com.emergentes.modelo.Miembros;
import java.util.List;


public interface MiembrosDAO {
    public void insert(Miembros miembros) throws Exception;
    public void delete(int id) throws Exception;
    public List<Miembros> getAll(int id) throws Exception;
    public List<Miembros> getAllm(int id) throws Exception;
    public List<Miembros> getAllmiembros(int id) throws Exception;
}
