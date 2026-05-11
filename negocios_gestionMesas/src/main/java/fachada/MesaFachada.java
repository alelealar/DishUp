package fachada;

import control.MesaControl;
import dtos.MesaDTO;
import excepcion.NegocioException;
import interfaz.IGestionMesas;
import java.util.List;

public class MesaFachada implements IGestionMesas{

    private final MesaControl mesaControl;

    public MesaFachada() {
        this.mesaControl = new MesaControl();
    }

    @Override
    public List<MesaDTO> obtenerMesasPorMesero(String idMesero) throws NegocioException {
        return mesaControl.obtenerMesasPorMesero(idMesero);
    }
}