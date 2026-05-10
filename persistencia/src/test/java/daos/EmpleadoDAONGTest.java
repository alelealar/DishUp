/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package daos;

import entidades.Empleado;
import enums.EstadoEmpleado;
import enums.RolEmpleado;
import excepciones.PersistenciaException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author DishUp
 */
public class EmpleadoDAONGTest {
    
 /*   
    @Test
    public void testInsertarEmpleado() throws PersistenciaException{
        EmpleadoDAO emDAO = new EmpleadoDAO();
        Empleado empleado = new Empleado("Paulina", "Leal", "Armenta", EstadoEmpleado.ACTIVO, "ME-002", RolEmpleado.MESERO);
        Empleado emGuardado = emDAO.insertarEmpleado(empleado);
        
        assertNotNull(emGuardado.getId());
        assertEquals(empleado.getNombres(), emGuardado.getNombres());
    }
    
    @Test
    public void testObtenerEmpleado_correcto() throws PersistenciaException{
        EmpleadoDAO emDAO = new EmpleadoDAO();
        Empleado empleado = new Empleado("Paulina", "Leal", "Armenta", EstadoEmpleado.ACTIVO, "ME-002", RolEmpleado.COCINERO);
        Empleado emGuardado = emDAO.insertarEmpleado(empleado);
        
        Empleado consultado = emDAO.obtenerEmpleado(emGuardado);
        assertNotNull(consultado.getId());
        assertEquals(consultado.getRol(), RolEmpleado.COCINERO);
        assertEquals(consultado.getUser(), emGuardado.getUser());
    }
    
    @Test
    public void testObtenerEmpleadoPorRol_noEncontrado() throws PersistenciaException{
        EmpleadoDAO emDAO = new EmpleadoDAO();
        Empleado empleado = new Empleado("Paulina", "Leal", "Armenta", EstadoEmpleado.ACTIVO, "ME-002", RolEmpleado.COCINERO);
        
        assertThrows(PersistenciaException.class, () -> {
            Empleado consultado = emDAO.obtenerEmpleado(empleado);
        });
    }
  
    
    @Test
    public void testObtenerEmpleadoPorUser_correcto() throws PersistenciaException{
        EmpleadoDAO emDAO = new EmpleadoDAO();
        Empleado empleado = new Empleado("Paulina", "Leal", "Armenta", EstadoEmpleado.ACTIVO, "ME-002", RolEmpleado.COCINERO);
        Empleado emGuardado = emDAO.insertarEmpleado(empleado);
        
        Empleado consultado = emDAO.obtenerEmpleadoPorUser(emGuardado.getUser());
        assertNotNull(consultado.getId());
    }
 */
    
////    @Test
////    public void testActualizarEstadoEmpleado_correcto() throws PersistenciaException{
////        EmpleadoDAO emDAO = new EmpleadoDAO();
////        Empleado empleado = new Empleado("Paulina", "Leal", "Armenta", EstadoEmpleado.INACTIVO, "ME-002", RolEmpleado.COCINERO);
////        Empleado emGuardado = emDAO.insertarEmpleado(empleado);
////        
////        emDAO.actualizarEstadoEmpleado(emGuardado.getId(), EstadoEmpleado.ACTIVO);
////        
////        Empleado actualizado = emDAO.obtenerEmpleado(emGuardado);
////        assertEquals(actualizado.getEstado(), EstadoEmpleado.ACTIVO);
////    }
}
