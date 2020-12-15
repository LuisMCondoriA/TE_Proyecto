
package com.emergentes.dao;

import com.emergentes.modelo.Movimientos;
import java.util.List;


public interface MovimientosDAO {
    public void insert(Movimientos movimientos) throws Exception;
    public void update(Movimientos movimientos) throws Exception;
    public void delete(int id) throws Exception;
    public Movimientos getById(int id) throws Exception; 
    public Movimientos getUsmod(int id) throws Exception;    
    public List<Movimientos> getAll(int id) throws Exception;   
    public Movimientos saldo(int id) throws Exception; 
}
