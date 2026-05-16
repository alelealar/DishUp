package objetosNegocio;

import adaptadores.EmpleadoNegocioAdapter;
import adaptadores.MesaNegocioAdapter;
import daos.MesaDAO;
import dtos.EmpleadoDTO;
import dtos.MesaDTO;
import entidades.Mesa;
import enums.EstadoEmpleadoDTO;
import enums.EstadoMesa;
import enums.RolEmpleadoDTO;
import excepcion.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IMesaDAO;
import java.util.List;

/**
 * BO de mesas.
 *
 * Trabaja hacia afuera con DTOs. Internamente convierte entidades y maneja
 * excepciones de persistencia hacia negocio.
 *
 * @author DishUp
 */
public class MesaBO {

    private final IMesaDAO mesaDAO;
    private final MesaNegocioAdapter mesaAdapter;
    private final EmpleadoNegocioAdapter empleadoAdapter;

    public MesaBO() {
        this.mesaDAO = new MesaDAO();
        this.mesaAdapter = new MesaNegocioAdapter();
        this.empleadoAdapter = new EmpleadoNegocioAdapter();
    }

    public MesaBO(IMesaDAO mesaDAO) {
        this.mesaDAO = mesaDAO;
        this.mesaAdapter = new MesaNegocioAdapter();
        this.empleadoAdapter = new EmpleadoNegocioAdapter();
    }

    public List<MesaDTO> obtenerMesasPorMesero(EmpleadoDTO empleado) throws NegocioException {
        try {
            List<Mesa> mesas = mesaDAO.obtenerMesasPorMesero(empleado.getId());

            return mesaAdapter.listaEntidadADTO(mesas);

        } catch (PersistenciaException ex) {

            throw new NegocioException("No fue posible obtener las mesas del mesero.", ex);
        }
    }
    
    public MesaDTO obtenerMesa(MesaDTO mesa) throws NegocioException{
        try {
            Mesa obtenida = mesaDAO.obtenerMesa(mesaAdapter.aEntidad(mesa));
            
            return mesaAdapter.aDTO(obtenida);
            
        } catch (PersistenciaException ex) {
            throw new NegocioException("No fue posible obtener la mesa", ex);
        }
    }
    
    public void eliminarMesa(MesaDTO mesa) throws NegocioException{            
        try {
            
            Mesa entidad = mesaAdapter.aEntidad(mesa);

            Mesa actual = mesaDAO.obtenerMesa(entidad);
            
            if (actual.getIdMesero() != null) {
                throw new NegocioException("No se puede eliminar una mesa asignada a un mesero.");
            }
            
            mesaDAO.eliminarMesa(entidad);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No fue posible eliminar la mesa", ex);
        }
    }
    
    public void agregarMesa(MesaDTO mesa) throws NegocioException{
        try {
            Mesa entidad = mesaAdapter.aEntidad(mesa);

            entidad.setIdMesero(null);
            entidad.setEstado(EstadoMesa.LIBRE);

            mesaDAO.insertarMesa(entidad);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No fue posible agregar la mesa", ex);
        }
    }  
    
    public void asignarMesaAMesero(MesaDTO mesa, EmpleadoDTO mesero) throws NegocioException{
        try {
            Mesa entidadMesa = mesaAdapter.aEntidad(mesa);
            Mesa actual = mesaDAO.obtenerMesa(entidadMesa);

            if (actual.getIdMesero() != null) {
                throw new NegocioException("La mesa ya está asignada a un mesero.");
            }

            if (mesero.getEstado() != EstadoEmpleadoDTO.ACTIVO) {
                throw new NegocioException("El mesero no está activo.");
            }

            mesaDAO.asignarMesaAMesero(entidadMesa, empleadoAdapter.aEntidad(mesero));
        } catch (PersistenciaException ex) {
            throw new NegocioException("No fue posible asignar la mesa al mesero", ex);
        }
    }
    
    public List<MesaDTO> obtenerMesasDisponibles() throws NegocioException  {
        try {

            List<Mesa> mesas = mesaDAO.obtenerMesasDisponibles();

            return mesaAdapter.listaEntidadADTO(mesas);

        } catch (PersistenciaException ex) {

            throw new NegocioException("No fue posible obtener las mesas del mesero.", ex);
        }
    }
}