package objetosNegocio;

import adaptadores.EmpleadoNegocioAdapter;
import daos.EmpleadoDAO;
import daos.MesaDAO;
import dtos.EmpleadoDTO;
import dtos.MesaDTO;
import entidades.Empleado;
import entidades.Mesa;
import enums.EstadoEmpleado;
import excepcion.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IEmpleadoDAO;
import interfaces.IMesaDAO;
import java.util.List;

public class EmpleadoBO {

    private final IEmpleadoDAO empleadoDAO;
    private final IMesaDAO mesaDAO;
    private final EmpleadoNegocioAdapter empleadoAdapter;

    public EmpleadoBO() {
        this.empleadoDAO = new EmpleadoDAO();
        this.mesaDAO = new MesaDAO();
        this.empleadoAdapter = new EmpleadoNegocioAdapter();
    }

    public EmpleadoBO(IEmpleadoDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
        this.mesaDAO = new MesaDAO();
        this.empleadoAdapter = new EmpleadoNegocioAdapter();
    }

    public EmpleadoDTO obtenerEmpleadoPorMesa(MesaDTO mesa) throws NegocioException {
        if (mesa == null || mesa.getIdMesero() == null) {
            return null;
        }
        try {

            Empleado consultado = empleadoDAO.obtenerEmpleadoPorId(mesa.getIdMesero());

            if (consultado == null) {
                throw new NegocioException("Empleado no encontrado.");
            }

            return empleadoAdapter.aDTO(consultado);

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al consultar empleado.", ex);
        }
    }

    public EmpleadoDTO login(EmpleadoDTO empleadoDTO) throws NegocioException {

        try {
            Empleado empleado = empleadoAdapter.aEntidad(empleadoDTO);

            Empleado consultado = empleadoDAO.obtenerEmpleadoPorId(empleadoDTO.getId());

            if (consultado == null) {
                throw new NegocioException("Usuario incorrecto.");
            }

            return empleadoAdapter.aDTO(consultado);

        } catch (PersistenciaException ex) {
            throw new NegocioException("No fue posible iniciar sesión.", ex);
        }
    }

    public void activarEmpleado(EmpleadoDTO empleadoDTO) throws NegocioException {

        try {
            Empleado empleado = empleadoAdapter.aEntidad(empleadoDTO);

            Empleado consultado = empleadoDAO.obtenerEmpleadoPorId(empleadoDTO.getId());

            if (consultado == null) {
                throw new NegocioException("Empleado no encontrado.");
            }

            empleadoDAO.actualizarEstadoEmpleado(consultado, EstadoEmpleado.ACTIVO);

        } catch (PersistenciaException ex) {
            throw new NegocioException("No fue posible activar el empleado.", ex);
        }
    }

    public void desactivarEmpleado(EmpleadoDTO empleadoDTO) throws NegocioException {

        try {
            Empleado empleado = empleadoAdapter.aEntidad(empleadoDTO);

            Empleado consultado = empleadoDAO.obtenerEmpleadoPorId(empleadoDTO.getId());

            if (consultado == null) {
                throw new NegocioException("Empleado no encontrado.");
            }
            empleadoDAO.actualizarEstadoEmpleado(consultado, EstadoEmpleado.INACTIVO);

            List<Mesa> mesasAsignadas = mesaDAO.obtenerMesasPorMesero(consultado.getId());

            for (Mesa mesa : mesasAsignadas) {
                mesaDAO.desasignarMesero(mesa);
            }

        } catch (PersistenciaException ex) {
            throw new NegocioException("No fue posible desactivar el empleado.", ex);
        }
    }

    public List<EmpleadoDTO> obtenerMeserosActivos() throws NegocioException {

        try {
            List<Empleado> empleados = empleadoDAO.obtenerMeserosActivos();
            return empleadoAdapter.listaEntidadADTO(empleados);

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al consultar meseros activos.", ex);
        }
    }

    public List<EmpleadoDTO> buscarMeserosNombreUser(EmpleadoDTO dto) throws NegocioException {

        try {
            List<Empleado> empleados =
                    empleadoDAO.buscarMeserosPorUserNombre(dto.getUser(), dto.getNombres());

            return empleadoAdapter.listaEntidadADTO(empleados);

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error en la búsqueda de meseros.", ex);
        }
    }
}