package control;

import daos.EmpleadoDAO;
import dtos.EmpleadoDTO;
import dtos.MesaDTO;
import excepciones.EmpleadosException;
import excepcion.NegocioException;
import interfaces.IEmpleadoDAO;
import java.util.List;
import objetosNegocio.EmpleadoBO;

public class EmpleadoControl {

    private final EmpleadoBO empleadoBO;

    public EmpleadoControl() {
        IEmpleadoDAO empleadoDAO = new EmpleadoDAO();
        this.empleadoBO = new EmpleadoBO(empleadoDAO);
    }

    public EmpleadoDTO obtenerEmpleadoPorMesa(MesaDTO mesa) throws EmpleadosException {
        
        if (mesa == null) {
            throw new EmpleadosException("La mesa no puede ser nula.");
        }

        if (mesa.getIdMesa()== null || mesa.getIdMesa().isBlank()) {
            throw new EmpleadosException("El ID de la mesa es obligatorio.");
        }
        try {
            return empleadoBO.obtenerEmpleadoPorMesa(mesa);
        } catch (NegocioException ex) {
            throw new EmpleadosException("No fue posible obtener la información del empleado.");
        }
    }

    public EmpleadoDTO login(EmpleadoDTO empleado) throws EmpleadosException {

        if (empleado == null) {
            throw new EmpleadosException("Empleado nulo.");
        }

        if (empleado.getUser() == null || empleado.getUser().isBlank()) {
            throw new EmpleadosException("Usuario obligatorio.");
        }

        try {
            return empleadoBO.login(empleado);
        } catch (NegocioException ex) {
            throw new EmpleadosException("Error al iniciar sesión del empleado.");
        }
    }

    public void activarEmpleado(EmpleadoDTO empleado) throws EmpleadosException {

        if (empleado == null) {
            throw new EmpleadosException("Empleado nulo.");
        }

        if (empleado.getUser() == null || empleado.getUser().isBlank()) {
            throw new EmpleadosException("Usuario obligatorio.");
        }

        try {
            empleadoBO.activarEmpleado(empleado);
        } catch (NegocioException ex) {
            throw new EmpleadosException("No fue posible activar al empleado.");
        }
    }

    public void desactivarEmpleado(EmpleadoDTO empleado) throws EmpleadosException {

        if (empleado == null) {
            throw new EmpleadosException("Empleado nulo.");
        }

        if (empleado.getUser() == null || empleado.getUser().isBlank()) {
            throw new EmpleadosException("Usuario obligatorio.");
        }

        try {
            empleadoBO.desactivarEmpleado(empleado);
        } catch (NegocioException ex) {
            throw new EmpleadosException("No fue posible desactivar al empleado.");
        }
    }

    public List<EmpleadoDTO> obtenerMeserosActivos() throws EmpleadosException {

        try {
            return empleadoBO.obtenerMeserosActivos();
        } catch (NegocioException ex) {
            throw new EmpleadosException("No fue posible consultar meseros activos.");
        }
    }

    public List<EmpleadoDTO> buscarMeserosNombreUser(EmpleadoDTO dto) throws EmpleadosException {

        if (dto == null) {
            throw new EmpleadosException("Empleado nulo.");
        }

        try {
            return empleadoBO.buscarMeserosNombreUser(dto);
        } catch (NegocioException ex) {
            throw new EmpleadosException("Error en la búsqueda de meseros.");
        }
    }
}