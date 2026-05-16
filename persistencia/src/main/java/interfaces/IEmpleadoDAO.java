/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package interfaces;

import entidades.Empleado;
import enums.EstadoEmpleado;
import excepciones.PersistenciaException;

/**
 *
 * @author DishUp
 */
public interface IEmpleadoDAO {
    
    public Empleado obtenerEmpleado(Empleado empleado) throws PersistenciaException;
    
    public Empleado obtenerEmpleadoPorUser(String user) throws PersistenciaException;
    
    public void actualizarEstadoEmpleado(String id, EstadoEmpleado estado) throws PersistenciaException;
}
