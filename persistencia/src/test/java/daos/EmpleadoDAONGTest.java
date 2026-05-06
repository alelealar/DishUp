/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package daos;

import entidades.Empleado;
import enums.EstadoMesero;
import enums.RolEmpleado;
import excepciones.PersistenciaException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author DishUp
 */
public class EmpleadoDAONGTest {
    
    
    @Test
    public void testInsertarEmpleado() throws PersistenciaException{
        EmpleadoDAO emDAO = new EmpleadoDAO();
        Empleado empleado = new Empleado("Alejansra", "Leal", "Armenta", EstadoMesero.ACTIVO, "ME-001", RolEmpleado.MESERO);
        Empleado emGuardado = emDAO.insertarEmpleado(empleado);
        
        assertNotNull(emGuardado.getId());
        assertEquals(empleado.getNombres(), emGuardado.getNombres());
    }
}
