/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package interfaces;

import entidades.Empleado;
import excepciones.PersistenciaException;

/**
 *
 * @author DishUp
 */
public interface IEmpleadoDAO {

    public Empleado insertarEmpleado(Empleado empleado) throws PersistenciaException;
}
