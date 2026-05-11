/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package interfaz;

import dtos.EmpleadoDTO;
import excepcion.NegocioException;

/**
 *
 * @author Alejandra Leal Armenta, 262719
 */
public interface IGestionEmpleados {
    
    EmpleadoDTO obtenerEmpleado(EmpleadoDTO empleado) throws NegocioException;

    EmpleadoDTO login(EmpleadoDTO empleado) throws NegocioException;

    void activarEmpleado(EmpleadoDTO empleado) throws NegocioException;
}
