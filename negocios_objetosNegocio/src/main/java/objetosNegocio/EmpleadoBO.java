/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package objetosNegocio;


import adaptadores.EmpleadoAdapter;
import daos.EmpleadoDAO;
import dto.EmpleadoDTO;
import entidadesMongo.Empleado;
import enums.EstadoEmpleado;
import excepcion.NegocioException;
import excepciones.PersistenciaException;



/**
 *
 * @author DishUp
 */

public class EmpleadoBO implements IEmpleadoBO{
    
    private final EmpleadoDAO emDAO;

    public EmpleadoBO() {
        this.emDAO = new EmpleadoDAO();
    }

    @Override
    public EmpleadoDTO obtenerEmpleado(EmpleadoDTO empleado) throws NegocioException {
        if (empleado == null) {
            throw new NegocioException("Empleado nulo");
        }

        if (empleado.getUser() == null || empleado.getUser().trim().isEmpty()) {
            throw new NegocioException("Usuario obligatorio");
        }

        if (empleado.getRol() == null || empleado.getRol().trim().isEmpty()) {
            throw new NegocioException("Rol obligatorio");
        }

        if (empleado.getEstado() == null || empleado.getEstado().trim().isEmpty()) {
            throw new NegocioException("Estado obligatorio");
        }
        
        Empleado entidad = EmpleadoAdapter.toEntity(empleado);
        
        Empleado consultado;

        try {
            consultado = emDAO.obtenerEmpleado(entidad);

            if (consultado == null) {
                throw new NegocioException("Empleado no encontrado");
            }

            return EmpleadoAdapter.toDTO(consultado);

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al consultar empleado: " + ex.getMessage());
        }
    }
    
    @Override
    public EmpleadoDTO login(EmpleadoDTO empleado) throws NegocioException {

        if (empleado == null) {
            throw new NegocioException("Empleado nulo");
        }

        if (empleado.getUser() == null || empleado.getUser().isBlank()) {
            throw new NegocioException("Usuario obligatorio");
        }

        String user = empleado.getUser();

        try {
            Empleado consultado = emDAO.obtenerEmpleadoPorUser(user);

            if (consultado == null) {
                throw new NegocioException("Usuario incorrecto");
            }

            return EmpleadoAdapter.toDTO(consultado);

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al iniciar sesión: " + ex.getMessage());
        }
    }

    @Override
    public void activarEmpleado(EmpleadoDTO empleado) throws NegocioException{
        if (empleado == null) {
            throw new NegocioException("Empleado nulo");
        }
        
        if (empleado.getId() == null) {
            throw new NegocioException("id nulo");
        }

        if (empleado.getUser() == null || empleado.getUser().isBlank()) {
            throw new NegocioException("Usuario obligatorio");
        }
        
        String user = empleado.getUser();
        
        try{
            Empleado consultado = emDAO.obtenerEmpleadoPorUser(user);
            
            if (consultado == null) {
                throw new NegocioException("Usuario incorrecto");
            }
            
            emDAO.actualizarEstadoEmpleado(consultado.getId(), EstadoEmpleado.ACTIVO);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al activar al empleado: " + ex.getMessage());
        }
    }
}
