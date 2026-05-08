/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package fachada;

import Interface.IEmpleadoBO;
import dto.EmpleadoDTO;
import excepcion.NegocioException;


/**
 *
 * @author DishUp
 */

public class EmpleadoFachada {
    
    private final IEmpleadoBO empleadoBO;

    public EmpleadoFachada(IEmpleadoBO empleadoBO) {
        this.empleadoBO = empleadoBO;
    }
    
    public EmpleadoDTO obtenerEmpleado(EmpleadoDTO empleado) throws NegocioException{
        return empleadoBO.obtenerEmpleado(empleado);
    }
    
    public EmpleadoDTO login(EmpleadoDTO empleado) throws NegocioException{
        return empleadoBO.login(empleado);
    }
    
    public void activarEmpleado(EmpleadoDTO empleado) throws NegocioException{
        empleadoBO.activarEmpleado(empleado);
    }
}
