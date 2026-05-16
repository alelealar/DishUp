package objetosNegocio;

import adaptadores.EmpleadoNegocioAdapter;
import adaptadores.MesaNegocioAdapter;
import daos.MesaDAO;
import dtos.EmpleadoDTO;
import dtos.MesaDTO;
import entidades.Mesa;
import enums.EstadoEmpleadoDTO;
import enums.RolEmpleado;
import enums.RolEmpleadoDTO;
import excepcion.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IMesaDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public List<MesaDTO> obtenerMesasPorMesero(String idMesero) throws NegocioException {

        if (idMesero == null || idMesero.isBlank()) {
            throw new NegocioException("El id del mesero es inválido.");
        }

        try {

            List<Mesa> mesas = mesaDAO.obtenerMesasPorMesero(idMesero);

            return mesaAdapter.listaEntidadADTO(mesas);

        } catch (PersistenciaException ex) {

            throw new NegocioException("No fue posible obtener las mesas del mesero.", ex);
        }
    }
    
    public MesaDTO obtenerMesa(MesaDTO mesa) throws NegocioException{
        if(mesa == null){
            throw new NegocioException("La mesa no puede ser nula");
        }
        
        if (mesa.getIdMesa()== null || mesa.getIdMesa().isBlank()) {
            throw new NegocioException("La mesa debe tener un ID");
        }
        
        try {
            Mesa obtenida = mesaDAO.obtenerMesa(mesaAdapter.aEntidad(mesa));
            
            return mesaAdapter.aDTO(obtenida);
            
        } catch (PersistenciaException ex) {
            throw new NegocioException("No fue posible obtener la mesa", ex);
        }
    }
    
    public void eliminarMesa(MesaDTO mesa) throws NegocioException{
        if(mesa == null){
            throw new NegocioException("La mesa no puede ser nula");
        }
        
        if (mesa.getIdMesa()== null || mesa.getIdMesa().isBlank()) {
            throw new NegocioException("La mesa debe tener un ID");
        }
        
        try {
            mesaDAO.eliminarMesa(mesaAdapter.aEntidad(mesa));
        } catch (PersistenciaException ex) {
            throw new NegocioException("No fue posible eliminar la mesa", ex);
        }
    }
    
    public void agregarMesa(MesaDTO mesa) throws NegocioException{
        if(mesa == null){
            throw new NegocioException("La mesa no puede ser nula");
        }
        
        if (mesa.getIdMesa()== null || mesa.getIdMesa().isBlank()) {
            throw new NegocioException("La mesa debe tener un ID");
        }
        
        try {
            mesaDAO.insertarMesa(mesaAdapter.aEntidad(mesa));
        } catch (PersistenciaException ex) {
            throw new NegocioException("No fue posible agregar la mesa", ex);
        }
    }
    
    public void asignarMesaAMesero(MesaDTO mesa, EmpleadoDTO mesero) throws NegocioException{
        if(mesa == null){
            throw new NegocioException("La mesa no puede ser nula");
        }
        
        if (mesa.getIdMesa()== null || mesa.getIdMesa().isBlank()) {
            throw new NegocioException("La mesa debe tener un ID");
        }
        
        if (mesero.getId() == null || mesero.getId().isBlank()) {
            throw new NegocioException("El mesero debe tener un ID");
        }
        
        if (mesero.getRol() != RolEmpleadoDTO.MESERO) {
            throw new NegocioException("El empleado no es mesero");
        }
        
        if (mesero.getEstado() != EstadoEmpleadoDTO.ACTIVO) {
            throw new NegocioException("El mesero no está activo");
        }
        try {
            mesaDAO.asignarMesaAMesero(mesaAdapter.aEntidad(mesa), empleadoAdapter.aEntidad(mesero));
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