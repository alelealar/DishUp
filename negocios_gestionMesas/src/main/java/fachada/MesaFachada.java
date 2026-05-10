package fachada;

import control.MesaControl;
import dtos.MesaDTO;
import excepcion.NegocioException;
import java.util.List;

public class MesaFachada {

    private final MesaControl mesaControl;

    public MesaFachada() {
        this.mesaControl = new MesaControl();
    }

    public List<MesaDTO> obtenerMesasPorMesero(String idMesero) throws NegocioException {
        return mesaControl.obtenerMesasPorMesero(idMesero);
    }
}