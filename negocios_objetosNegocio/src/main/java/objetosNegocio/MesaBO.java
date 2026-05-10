package objetosNegocio;

import adaptadores.MesaNegocioAdapter;
import daos.MesaDAO;
import dtos.MesaDTO;
import entidades.Mesa;
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

    public MesaBO() {
        this.mesaDAO = new MesaDAO();
        this.mesaAdapter = new MesaNegocioAdapter();
    }

    public MesaBO(IMesaDAO mesaDAO) {
        this.mesaDAO = mesaDAO;
        this.mesaAdapter = new MesaNegocioAdapter();
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
  
}

/*
        mesas.add(new MesaDTO(1, 1, EstadoMesaDTO.LIBRE, 1));
        mesas.add(new MesaDTO(2, 2, EstadoMesaDTO.LIBRE, 1));
        mesas.add(new MesaDTO(3, 4, EstadoMesaDTO.LIBRE, 1));
        mesas.add(new MesaDTO(4, 6, EstadoMesaDTO.LIBRE, 1));
        mesas.add(new MesaDTO(5, 7, EstadoMesaDTO.LIBRE, 1));
        mesas.add(new MesaDTO(6, 9, EstadoMesaDTO.LIBRE, 1));
*/
