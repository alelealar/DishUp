package control;

import daos.EmpleadoDAO;
import dtos.EmpleadoDTO;
import excepcion.NegocioException;
import interfaces.IEmpleadoDAO;
import objetosNegocio.EmpleadoBO;

public class EmpleadoControl {

    private final EmpleadoBO empleadoBO;

    public EmpleadoControl() {
        IEmpleadoDAO empleadoDAO = new EmpleadoDAO();
        this.empleadoBO = new EmpleadoBO(empleadoDAO);
    }

    public EmpleadoDTO obtenerEmpleado(EmpleadoDTO empleado) throws NegocioException {
        return empleadoBO.obtenerEmpleado(empleado);
    }

    public EmpleadoDTO login(EmpleadoDTO empleado) throws NegocioException {
        return empleadoBO.login(empleado);
    }

    public void activarEmpleado(EmpleadoDTO empleado) throws NegocioException {
        empleadoBO.activarEmpleado(empleado);
    }
}