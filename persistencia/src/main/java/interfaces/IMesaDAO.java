/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Empleado;
import entidades.Mesa;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author DishUp
 */
public interface IMesaDAO {

    public List<Mesa> obtenerMesasPorMesero(String idMesero) throws PersistenciaException;

    public void insertarMesa(Mesa mesa) throws PersistenciaException;
    
    public void eliminarMesa(Mesa mesa) throws PersistenciaException;
    
    public Mesa obtenerMesa(Mesa mesa) throws PersistenciaException;
    
    public void asignarMesaAMesero(Mesa mesa, Empleado mesero) throws PersistenciaException; 
    
    public List<Mesa> obtenerMesasDisponibles() throws PersistenciaException;
}
