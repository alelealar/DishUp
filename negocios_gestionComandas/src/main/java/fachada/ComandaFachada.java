/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import BO.ComandaBO;
import dto.ComandaDTO;
import dto.PedidoNuevoDTO;
import java.util.List;

/**
 *
 * @author DishUp
 */
public class ComandaFachada {

    private final ComandaBO comandaBO;

    public ComandaFachada(ComandaBO comandaBO) {
        this.comandaBO = comandaBO;
    }

    public void crearComanda(String nombreCliente, int numeroMesa, List<PedidoNuevoDTO> pedidos) {
        comandaBO.crearComanda(nombreCliente, numeroMesa, pedidos);
    }

    public List<ComandaDTO> obtenerComandasPorMesa(int numeroMesa) {
        return comandaBO.obtenerComandasPorMesa(numeroMesa);
    }
}
