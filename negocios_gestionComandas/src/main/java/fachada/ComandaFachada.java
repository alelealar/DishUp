package fachada;

import control.ComandaControl;
import dtos.ComandaDTO;
import dtos.PedidoNuevoDTO;
import excepcion.NegocioException;
import interfaces.IGestionComandas;
import java.util.List;

public class ComandaFachada implements IGestionComandas{

    private final ComandaControl comandaControl;

    public ComandaFachada() {
        this.comandaControl = new ComandaControl();
    }

    @Override
    public void crearComanda(String nombreCliente,int numeroMesa,List<PedidoNuevoDTO> pedidos) throws NegocioException {
        comandaControl.crearComanda(nombreCliente,numeroMesa,pedidos);
    }

    @Override
    public List<ComandaDTO> obtenerComandasPorMesa(int numeroMesa) throws NegocioException {
        return comandaControl.obtenerComandasPorMesa(numeroMesa);
    }
}