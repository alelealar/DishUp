package control;

import fachada.MesaFachada;
import dto.MesaDTO;
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

    public List<MesaDTO> obtenerMesasPorMesero(int idMesero) {
        return fachada.obtenerMesasPorMesero(idMesero);
    }
}