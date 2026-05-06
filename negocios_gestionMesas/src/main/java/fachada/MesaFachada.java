
package fachada;

import BO.MesaBO;
import Interface.IMesaBO;
import dto.MesaDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 * 
 * @author DishUp
 */
public class MesaFachada {

    private IMesaBO mesaBO;

    public MesaFachada() {
        this.mesaBO = new MesaBO();
    }

    public List<MesaDTO> obtenerMesasPorMesero(String idMesero) throws NegocioException {
        return mesaBO.obtenerMesasPorMesero(idMesero);
    }
}