/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dto.EmpleadoDTO;
import excepcion.NegocioException;
import fachada.EmpleadoFachada;


/**
 *
 * @author DishUp
 */

public class EmpleadoControl {
    private final EmpleadoFachada empleadoFachada;

    public EmpleadoControl(EmpleadoFachada empleadoFachada) {
        this.empleadoFachada = empleadoFachada;
    }

    public EmpleadoFachada getEmpleadoFachada() {
        return empleadoFachada;
    }
    
    public EmpleadoDTO obtenerEmpleado(EmpleadoDTO empleado) throws NegocioException{
        return empleadoFachada.obtenerEmpleado(empleado);
    }
    
    public EmpleadoDTO login(EmpleadoDTO empleado) throws NegocioException{
        return empleadoFachada.login(empleado);
    }
    
    public void activarEmpleado(EmpleadoDTO empleado) throws NegocioException{
        empleadoFachada.activarEmpleado(empleado);
    }
}
