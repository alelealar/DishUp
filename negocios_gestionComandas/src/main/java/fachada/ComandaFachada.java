package fachada;

import control.ComandaControl;
import dtos.ComandaDTO;
import dtos.EmpleadoDTO;
import dtos.PedidoDTO;
import excepcion.NegocioException;
import interfaces.IGestionComandas;
import java.util.List;

public class ComandaFachada implements IGestionComandas {

    private final ComandaControl comandaControl;

    public ComandaFachada() {
        this.comandaControl = new ComandaControl();
    }

    @Override
    public void crearComanda(String nombreCliente, int numeroMesa, List<PedidoDTO> pedidos, EmpleadoDTO empleadoActual) throws NegocioException {
        comandaControl.crearComanda(nombreCliente, numeroMesa, pedidos, empleadoActual);
    }

    @Override
    public List<ComandaDTO> obtenerComandasPorMesa(int numeroMesa) throws NegocioException {
        return comandaControl.obtenerComandasPorMesa(numeroMesa);
    }

    @Override
    public void agregarPedidosAComanda(String idComanda, List<PedidoDTO> pedidos) throws NegocioException {
        comandaControl.agregarPedidoAComanda(idComanda, pedidos);
    }
}
