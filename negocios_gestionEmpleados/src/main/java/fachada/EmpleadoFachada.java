package fachada;

import control.EmpleadoControl;
import dtos.EmpleadoDTO;
import excepcion.NegocioException;

public class EmpleadoFachada {

    private final EmpleadoControl empleadoControl;

    public EmpleadoFachada() {
        this.empleadoControl = new EmpleadoControl();
    }

    public EmpleadoDTO obtenerEmpleado(EmpleadoDTO empleado) throws NegocioException {
       return empleadoControl.obtenerEmpleado(empleado);
    }

    public EmpleadoDTO login(EmpleadoDTO empleado) throws NegocioException {
        return empleadoControl.login(empleado);
    }

    public void activarEmpleado(EmpleadoDTO empleado) throws NegocioException {
        empleadoControl.activarEmpleado(empleado);
    }
}