package fabricas;

import BO.EmpleadoBO;
import control.EmpleadoControl;
import daos.EmpleadoDAO;
import fachada.EmpleadoFachada;
import interfaces.IEmpleadoDAO;

public class FabricaEmpleados {

    public static EmpleadoControl crear() {

        IEmpleadoDAO empleadoDAO = new EmpleadoDAO();

        EmpleadoBO bo = new EmpleadoBO();

        EmpleadoFachada fachada = new EmpleadoFachada(bo);

        return new EmpleadoControl(fachada);
    }
}