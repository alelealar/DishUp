package control;

import daos.EmpleadoDAO;
import dtos.EmpleadoDTO;
import excepcion.NegocioException;
import excepciones.EmpleadosException;
import interfaces.IEmpleadoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetosNegocio.EmpleadoBO;

public class EmpleadoControl {

    private final EmpleadoBO empleadoBO;

    public EmpleadoControl() {
        IEmpleadoDAO empleadoDAO = new EmpleadoDAO();
        this.empleadoBO = new EmpleadoBO(empleadoDAO);
    }

    public EmpleadoDTO obtenerEmpleado(EmpleadoDTO empleado) throws EmpleadosException {
        try {
            return empleadoBO.obtenerEmpleado(empleado);
        } catch (NegocioException ex) {
            throw new EmpleadosException( "No fue posible obtener la información del empleado.");
        }
    }

    public EmpleadoDTO login(EmpleadoDTO empleado) throws EmpleadosException {
        try {
            return empleadoBO.login(empleado);
        } catch (NegocioException ex) {
            throw new EmpleadosException( "Error al iniciar sesión del empleado.");
        }
    }

    public void activarEmpleado(EmpleadoDTO empleado) throws EmpleadosException {
        try {
            empleadoBO.activarEmpleado(empleado);
        } catch (NegocioException ex) {
            throw new EmpleadosException( "No fue posible activar al empleado.");
        }
    }
}