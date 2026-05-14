package control;

import daos.MesaDAO;
import dtos.MesaDTO;
import excepcion.NegocioException;
import excepciones.MesasException;
import interfaces.IMesaDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetosNegocio.MesaBO;

public class MesaControl {

    private final MesaBO mesaBO;

    public MesaControl() {
        IMesaDAO mesaDAO = new MesaDAO();
        this.mesaBO = new MesaBO(mesaDAO);
    }

    public List<MesaDTO> obtenerMesasPorMesero(String idMesero) throws MesasException {
        try {
            return mesaBO.obtenerMesasPorMesero(idMesero);
            
            /*
            List<MesaDTO> mesas = new ArrayList<>();
            
            mesas.add(new MesaDTO("M1", 1, EstadoMesaDTO.LIBRE, idMesero));
            mesas.add(new MesaDTO("M2", 2, EstadoMesaDTO.OCUPADA, idMesero));
            mesas.add(new MesaDTO("M3", 3, EstadoMesaDTO.LIBRE, idMesero));
            mesas.add(new MesaDTO("M4", 4, EstadoMesaDTO.LIBRE, idMesero));
            mesas.add(new MesaDTO("M5", 5, EstadoMesaDTO.OCUPADA, idMesero));
            mesas.add(new MesaDTO("M6", 6, EstadoMesaDTO.LIBRE, idMesero));
            
            return mesas;
            */
        } catch (NegocioException ex) {
            throw new MesasException( "No fue posible obtener las mesas asignadas al mesero.");
        }
    }
}