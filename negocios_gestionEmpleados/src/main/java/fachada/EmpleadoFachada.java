package fachada;

import control.EmpleadoControl;
import dtos.EmpleadoDTO;
import excepciones.EmpleadosException;
import interfaz.IGestionEmpleados;

public class EmpleadoFachada implements IGestionEmpleados{

    private final EmpleadoControl empleadoControl;

    public EmpleadoFachada() {
        this.empleadoControl = new EmpleadoControl();
    }

    @Override
    public EmpleadoDTO obtenerEmpleado(EmpleadoDTO empleado) throws EmpleadosException {
       return empleadoControl.obtenerEmpleado(empleado);
    }

    @Override
    public EmpleadoDTO login(EmpleadoDTO empleado) throws EmpleadosException {
        return empleadoControl.login(empleado);
    }

    @Override
    public void activarEmpleado(EmpleadoDTO empleado) throws EmpleadosException {
        empleadoControl.activarEmpleado(empleado);
    }
}