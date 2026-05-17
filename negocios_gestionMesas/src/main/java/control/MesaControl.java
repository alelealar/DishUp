package control;

import daos.MesaDAO;
import dtos.EmpleadoDTO;
import dtos.MesaDTO;
import enums.EstadoEmpleadoDTO;
import enums.EstadoMesaDTO;
import enums.RolEmpleadoDTO;
import excepcion.NegocioException;
import excepciones.MesasException;
import interfaces.IMesaDAO;
import java.util.List;
import objetosNegocio.MesaBO;

public class MesaControl {

    private final MesaBO mesaBO;

    public MesaControl() {
        IMesaDAO mesaDAO = new MesaDAO();
        this.mesaBO = new MesaBO(mesaDAO);
    }


    private void validarMesa(MesaDTO mesa) throws MesasException {
        if (mesa == null) {
            throw new MesasException("La mesa no puede ser nula");
        }
        if (mesa.getIdMesa() == null || mesa.getIdMesa().isBlank()) {
            throw new MesasException("La mesa debe tener un ID");
        }
    }

    private void validarEmpleado(EmpleadoDTO empleado) throws MesasException {
        if (empleado == null) {
            throw new MesasException("El empleado no puede ser nulo");
        }
        if (empleado.getId() == null || empleado.getId().isBlank()) {
            throw new MesasException("El empleado debe tener un ID");
        }
    }


    public List<MesaDTO> obtenerMesasPorMesero(EmpleadoDTO empleado) throws MesasException {
        validarEmpleado(empleado);

        try {
            return mesaBO.obtenerMesasPorMesero(empleado);
        } catch (NegocioException ex) {
            throw new MesasException("No fue posible obtener las mesas asignadas al mesero.");
        }
    }

    public MesaDTO obtenerMesaPorId(MesaDTO mesa) throws MesasException {
        validarMesa(mesa);

        try {
            return mesaBO.obtenerMesa(mesa);
        } catch (NegocioException ex) {
            throw new MesasException("No fue posible obtener la mesa.");
        }
    }

    public void eliminarMesa(MesaDTO mesa) throws MesasException {
        validarMesa(mesa);

        try {
            mesaBO.eliminarMesa(mesa);
        } catch (NegocioException ex) {
            throw new MesasException("No fue posible eliminar la mesa.");
        }
    }

    public void agregarMesa(MesaDTO mesa) throws MesasException {
        if (mesa == null) {
            throw new MesasException("La mesa no puede ser nula");
        }

        if (mesa.getNumeroMesa()<= 0) {
            throw new MesasException("El número de mesa debe ser mayor a 0");
        }
        
        mesa.setEstado(EstadoMesaDTO.LIBRE);

        try {
            mesaBO.agregarMesa(mesa);
        } catch (NegocioException ex) {
            throw new MesasException("No fue posible agregar la mesa.");
        }
    }

    public void asignarMesaAMesero(MesaDTO mesa, EmpleadoDTO mesero) throws MesasException {

        validarMesa(mesa);
        validarEmpleado(mesero);

        if (mesero.getRol() == null) {
            throw new MesasException("El rol del empleado es obligatorio");
        }

        if (mesero.getRol() != RolEmpleadoDTO.MESERO) {
            throw new MesasException("El empleado no es mesero");
        }

        if (mesero.getEstado() == null) {
            throw new MesasException("El estado del empleado es obligatorio");
        }

        if (mesero.getEstado() != EstadoEmpleadoDTO.ACTIVO) {
            throw new MesasException("El mesero no está activo");
        }

        try {
            mesaBO.asignarMesaAMesero(mesa, mesero);
        } catch (NegocioException ex) {
            throw new MesasException("No fue posible asignar la mesa al mesero.");
        }
    }

    public List<MesaDTO> obtenerMesasDisponibles() throws MesasException {
        try {
            return mesaBO.obtenerMesasDisponibles();
        } catch (NegocioException ex) {
            throw new MesasException("No fue posible obtener las mesas disponibles.");
        }
    }
    
    public List<MesaDTO> obtenerMesas() throws MesasException {
        try {
            return mesaBO.obtenerMesas();
        } catch (NegocioException ex) {
            throw new MesasException("No fue posible obtener las mesas disponibles.");
        }
    }
}