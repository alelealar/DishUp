package objetosNegocio;

import adaptadores.EmpleadoNegocioAdapter;
import daos.EmpleadoDAO;
import dtos.EmpleadoDTO;
import entidades.Empleado;
import enums.EstadoEmpleado;
import enums.EstadoEmpleadoDTO;
import excepcion.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IEmpleadoDAO;

public class EmpleadoBO {

    private final IEmpleadoDAO empleadoDAO;
    private final EmpleadoNegocioAdapter empleadoAdapter;

    public EmpleadoBO() {
        this.empleadoDAO = new EmpleadoDAO();
        this.empleadoAdapter = new EmpleadoNegocioAdapter();
    }

    public EmpleadoBO(IEmpleadoDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
        this.empleadoAdapter = new EmpleadoNegocioAdapter();
    }

    public EmpleadoDTO obtenerEmpleado(EmpleadoDTO empleadoDTO) throws NegocioException {

        validarEmpleadoConsulta(empleadoDTO);

        try {

            Empleado empleado = empleadoAdapter.aEntidad(empleadoDTO);

            Empleado consultado = empleadoDAO.obtenerEmpleado(empleado);

            if (consultado == null) {
                throw new NegocioException("Empleado no encontrado.");
            }

            return empleadoAdapter.aDTO(consultado);

        } catch (PersistenciaException ex) {
            throw new NegocioException("No fue posible consultar el empleado.", ex);
        }
    }

    public EmpleadoDTO login(EmpleadoDTO empleadoDTO) throws NegocioException {

        if (empleadoDTO == null) {
            throw new NegocioException("Empleado nulo.");
        }

        if (empleadoDTO.getUser() == null || empleadoDTO.getUser().isBlank()) {

            throw new NegocioException("Usuario obligatorio.");
        }

        try {

            Empleado consultado = empleadoDAO.obtenerEmpleadoPorUser(empleadoDTO.getUser());

            if (consultado == null) {
                throw new NegocioException("Usuario incorrecto.");
            }

            return empleadoAdapter.aDTO(consultado);

        } catch (PersistenciaException ex) {
            throw new NegocioException("No fue posible iniciar sesión.", ex);
        }
    }

    public void activarEmpleado(EmpleadoDTO empleadoDTO) throws NegocioException {

        if (empleadoDTO == null) {
            throw new NegocioException("Empleado nulo.");
        }

        if (empleadoDTO.getUser() == null || empleadoDTO.getUser().isBlank()) {
            throw new NegocioException("Usuario obligatorio.");
        }

        try {

            Empleado consultado = empleadoDAO.obtenerEmpleadoPorUser(empleadoDTO.getUser());

            if (consultado == null) {
                throw new NegocioException("Empleado no encontrado.");
            }

            empleadoDAO.actualizarEstadoEmpleado(
                    consultado.getId(),
                    EstadoEmpleado.ACTIVO
            );

        } catch (PersistenciaException ex) {
            throw new NegocioException("No fue posible activar el empleado.", ex);
        }
    }

    private void validarEmpleadoConsulta(EmpleadoDTO empleadoDTO) throws NegocioException {

        if (empleadoDTO == null) {
            throw new NegocioException("Empleado nulo.");
        }

        if (empleadoDTO.getUser() == null || empleadoDTO.getUser().isBlank()) {

            throw new NegocioException("Usuario obligatorio.");
        }

        if (empleadoDTO.getRol() == null) {

            throw new NegocioException("Rol obligatorio.");
        }

        if (empleadoDTO.getEstado() == null) {

            throw new NegocioException("Estado obligatorio.");
        }
    }
}