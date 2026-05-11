/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package interfaces;

import dtos.ComandaDTO;
import dtos.PedidoNuevoDTO;
import excepcion.NegocioException;
import java.util.List;

/**
 *
 * @author Alejandra Leal Armenta, 262719
 */
public interface IGestionComandas {
    
    void crearComanda(String nombreCliente, int numeroMesa, List<PedidoNuevoDTO> pedidos) throws NegocioException;

    List<ComandaDTO> obtenerComandasPorMesa(int numeroMesa) throws NegocioException;
}
