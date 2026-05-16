package objetosNegocio;

import adaptadores.EmpleadoNegocioAdapter;
import daos.EmpleadoDAO;
import dtos.EmpleadoDTO;
import entidades.Empleado;
import enums.EstadoEmpleado;
import excepcion.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IEmpleadoDAO;
import java.util.List;

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
            throw new NegocioException("Error al consultar al empleado: "+ex.getMessage(), ex);
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

            Empleado consultado = empleadoDAO.obtenerEmpleado(empleadoAdapter.aEntidad(empleadoDTO));

            if (consultado == null) {
                throw new NegocioException("Usuario incorrecto.");
            }

            return empleadoAdapter.aDTO(consultado);

        } catch (PersistenciaException ex) {
            throw new NegocioException("No fue posible iniciar sesión: "+ex.getMessage(), ex);
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

            Empleado consultado = empleadoDAO.obtenerEmpleado(empleadoAdapter.aEntidad(empleadoDTO));

            if (consultado == null) {
                throw new NegocioException("Empleado no encontrado.");
            }

            empleadoDAO.actualizarEstadoEmpleado(
                    consultado,
                    EstadoEmpleado.ACTIVO
            );

        } catch (PersistenciaException ex) {
            throw new NegocioException("No fue posible activar el empleado: "+ex.getMessage(), ex);
        }
    }

    public List<EmpleadoDTO> obtenerMeserosActivos() throws NegocioException{
        
        try{
            List<Empleado> dominios = empleadoDAO.obtenerMeserosActivos();
            
            return empleadoAdapter.listaEntidadADTO(dominios);
            
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al consultar a los meseros activos: "+ex.getMessage());
        }
    }
    
    public List<EmpleadoDTO> buscarMeserosNombreUser(EmpleadoDTO dto) throws NegocioException{
        try{
            List<Empleado> dominios = empleadoDAO.buscarMeserosPorUserNombre(dto.getUser(), dto.getNombres());
            
            return empleadoAdapter.listaEntidadADTO(dominios);
            
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error en la busqueda: "+ex.getMessage());
        }
    }
    
    public void desactivarEmpleado(EmpleadoDTO empleadoDTO) throws NegocioException {

        if (empleadoDTO == null) {
            throw new NegocioException("Empleado nulo.");
        }

        if (empleadoDTO.getUser() == null || empleadoDTO.getUser().isBlank()) {
            throw new NegocioException("Usuario obligatorio.");
        }

        try {

            Empleado consultado = empleadoDAO.obtenerEmpleado(empleadoAdapter.aEntidad(empleadoDTO));

            if (consultado == null) {
                throw new NegocioException("Empleado no encontrado.");
            }

            empleadoDAO.actualizarEstadoEmpleado(
                    consultado,
                    EstadoEmpleado.INACTIVO
            );

        } catch (PersistenciaException ex) {
            throw new NegocioException("No fue posible desactivar el empleado: "+ex.getMessage(), ex);
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