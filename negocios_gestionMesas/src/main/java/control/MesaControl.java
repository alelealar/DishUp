package control;

import fachada.MesaFachada;
import dto.MesaDTO;
import excepcion.NegocioException;
import java.util.List;

/**
 *
 * @author DishUp
 */
public class MesaControl {

    private final MesaFachada fachada;

    public MesaControl(MesaFachada fachada) {
        this.fachada = fachada;
    }

    public List<MesaDTO> obtenerMesasPorMesero(String idMesero) throws NegocioException {
        return fachada.obtenerMesasPorMesero(idMesero);
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
    }
}
