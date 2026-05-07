/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dto.ComandaDTO;
import dto.PedidoNuevoDTO;
import fachada.ComandaFachada;
import java.util.List;

/**
 *
 * @author DishUp
 */
public class ComandaControl {

    private final ComandaFachada comandaFachada;

    public ComandaControl(ComandaFachada fachada) {
        this.comandaFachada = fachada;
    }

    public void crearComanda(String nombreCliente, int numeroMesa, List<PedidoNuevoDTO> pedidos) {
        comandaFachada.crearComanda(nombreCliente, numeroMesa, pedidos);
    }

    public List<ComandaDTO> obtenerComandasPorMesa(int numeroMesa) {
        return comandaFachada.obtenerComandasPorMesa(numeroMesa);
    }

}
