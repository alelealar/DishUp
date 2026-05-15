/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package interfaz;

import dtos.EmpleadoDTO;
import excepciones.EmpleadosException;

/**
 *
 * @author DishUp
 */
public interface IGestionEmpleados {
    
    EmpleadoDTO obtenerEmpleado(EmpleadoDTO empleado) throws EmpleadosException;

    EmpleadoDTO login(EmpleadoDTO empleado) throws EmpleadosException;

    void activarEmpleado(EmpleadoDTO empleado) throws EmpleadosException;
}
