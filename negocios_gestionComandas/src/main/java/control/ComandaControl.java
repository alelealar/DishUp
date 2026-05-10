package control;

import dtos.ComandaDTO;
import dtos.PedidoNuevoDTO;
import excepcion.NegocioException;
import java.util.List;
import objetosNegocio.ComandaBO;

public class ComandaControl {

    private final ComandaBO comandaBO;

    public ComandaControl() {
        this.comandaBO = new ComandaBO();
    }

    public void crearComanda(String nombreCliente, int numeroMesa, List<PedidoNuevoDTO> pedidos) throws NegocioException {
        comandaBO.crearComanda(nombreCliente, numeroMesa, pedidos);
    }

    public List<ComandaDTO> obtenerComandasPorMesa(int numeroMesa) throws NegocioException {
        return comandaBO.obtenerComandasPorMesa(numeroMesa);
    }
}