/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package Interface;

import dto.EmpleadoDTO;
import excepcion.NegocioException;

/**
 *
 * @author DishUp
 */
public interface IEmpleadoBO {

    public EmpleadoDTO obtenerEmpleado(EmpleadoDTO empleado) throws NegocioException;
    
    public EmpleadoDTO login(EmpleadoDTO empleado) throws NegocioException;
    
    public void activarEmpleado(EmpleadoDTO empleado) throws NegocioException;
}
