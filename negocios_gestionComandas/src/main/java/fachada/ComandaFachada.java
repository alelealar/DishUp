package fachada;

import control.ComandaControl;
import dtos.ComandaDTO;
import dtos.EmpleadoDTO;
import dtos.PedidoDTO;
import excepciones.ComandasException;
import interfaces.IGestionComandas;
import java.util.List;

public class ComandaFachada implements IGestionComandas {

    private final ComandaControl comandaControl;

    public ComandaFachada() {
        this.comandaControl = new ComandaControl();
    }

    @Override
    public void crearComanda(String nombreCliente, int numeroMesa, List<PedidoDTO> pedidos, EmpleadoDTO empleadoActual) throws ComandasException {
        comandaControl.crearComanda(nombreCliente, numeroMesa, pedidos, empleadoActual);
    }

    @Override
    public List<ComandaDTO> obtenerComandasPorMesa(int numeroMesa) throws ComandasException {
        return comandaControl.obtenerComandasPorMesa(numeroMesa);
    }

    @Override
    public void agregarPedidosAComanda(String idComanda, List<PedidoDTO> pedidos) throws ComandasException {
        comandaControl.agregarPedidoAComanda(idComanda, pedidos);
    }
}
