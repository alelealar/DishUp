package control;

import dtos.ComandaDTO;
import dtos.EmpleadoDTO;
import dtos.PedidoDTO;
import excepcion.NegocioException;
import excepciones.ComandasException;
import java.util.List;
import objetosNegocio.ComandaBO;

public class ComandaControl {

    private final ComandaBO comandaBO;

    public ComandaControl() {
        this.comandaBO = new ComandaBO();
    }

    public void crearComanda(String nombreCliente, int numeroMesa, List<PedidoDTO> pedidos, EmpleadoDTO empleadoActual) throws ComandasException {
        try {
            comandaBO.crearComanda(nombreCliente, numeroMesa, pedidos, empleadoActual);
        } catch (NegocioException ex) {
            throw new ComandasException("Ocurrió un error al crear la comanda del cliente: " + nombreCliente);
        }
    }

    public List<ComandaDTO> obtenerComandasPorMesa(int numeroMesa) throws ComandasException {
        return comandaBO.obtenerComandasPorMesa(numeroMesa);
    }

    public void agregarPedidoAComanda(String idComanda, List<PedidoDTO> pedidos) throws ComandasException {
        try {
            comandaBO.agregarPedidosAComanda(idComanda, pedidos);
        } catch (NegocioException ex) {
            throw new ComandasException("No fue posible agregar pedidos a la comanda con ID: " + idComanda);
        }
    }
    
    public boolean eliminarComanda(String idComanda) throws ComandasException {
        try {
            return comandaBO.eliminarComanda(idComanda);
        } catch (NegocioException ex) {
            throw new ComandasException("No fue posible eliminar la comanda: " + ex.getMessage());
        }
    }
}
