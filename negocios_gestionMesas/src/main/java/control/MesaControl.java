package control;

import daos.MesaDAO;
import dtos.MesaDTO;
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

    public List<MesaDTO> obtenerMesasPorMesero(String idMesero) throws MesasException {
        try {
            return mesaBO.obtenerMesasPorMesero(idMesero);
        } catch (NegocioException ex) {
            throw new MesasException( "No fue posible obtener las mesas asignadas al mesero.");
        }
    }
}