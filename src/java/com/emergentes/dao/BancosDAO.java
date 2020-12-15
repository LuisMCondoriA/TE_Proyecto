
package com.emergentes.dao;

import com.emergentes.modelo.Bancos;
import java.util.List;


public interface BancosDAO {
    public void insert(Bancos bancos) throws Exception;
    public void update(Bancos bancos) throws Exception;
    public void delete(int id) throws Exception;
    public Bancos getById(int id) throws Exception;  
    public List<Bancos> getAll(int id) throws Exception;
}
