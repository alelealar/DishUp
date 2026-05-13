package control;

import dtos.ComandaDTO;
import dtos.EmpleadoDTO;
import dtos.PedidoDTO;
import excepcion.NegocioException;
import java.util.List;
import objetosNegocio.ComandaBO;

public class ComandaControl {

    private final ComandaBO comandaBO;

    public ComandaControl() {
        this.comandaBO = new ComandaBO();
    }

    public void crearComanda(String nombreCliente, int numeroMesa, List<PedidoDTO> pedidos, EmpleadoDTO empleadoActual) throws NegocioException {
        comandaBO.crearComanda(nombreCliente, numeroMesa, pedidos, empleadoActual);
    }

    public List<ComandaDTO> obtenerComandasPorMesa(int numeroMesa) throws NegocioException {
        return comandaBO.obtenerComandasPorMesa(numeroMesa);
    }

    public void agregarPedidoAComanda(String idComanda, List<PedidoDTO> pedidos) throws NegocioException {
        comandaBO.agregarPedidosAComanda(idComanda, pedidos);
    }
}
