package control;

import fachada.MesaFachada;
import dto.MesaDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 * 
 * @author DishUp
 */
public class MesaControl {

    private MesaFachada fachada;

    public MesaControl() {
        this.fachada = new MesaFachada();
    }

    public List<MesaDTO> obtenerMesasPorMesero(String idMesero) throws NegocioException {
        return fachada.obtenerMesasPorMesero(idMesero);
    }
}