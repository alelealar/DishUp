
package fachada;

import Interface.IMesaBO;
import dto.MesaDTO;
import excepcion.NegocioException;
import java.util.List;

/**
 * 
 * @author DishUp
 */
public class MesaFachada {

    private final IMesaBO mesaBO;

    public MesaFachada(IMesaBO mesaBO) {
        this.mesaBO = mesaBO;
    }

    public List<MesaDTO> obtenerMesasPorMesero(String idMesero) throws NegocioException {
        return mesaBO.obtenerMesasPorMesero(idMesero);
    }
}