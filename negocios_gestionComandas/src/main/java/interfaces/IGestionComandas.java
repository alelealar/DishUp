/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package interfaces;

import dtos.ComandaDTO;
import dtos.EmpleadoDTO;
import dtos.PedidoDTO;
import excepcion.NegocioException;
import java.util.List;

/**
 *
 * @author Alejandra Leal Armenta, 262719
 */
public interface IGestionComandas {
    
    public void crearComanda(String nombreCliente,int numeroMesa,List<PedidoDTO> pedidos, EmpleadoDTO empleadoActual) throws NegocioException;

    public List<ComandaDTO> obtenerComandasPorMesa(int numeroMesa) throws NegocioException;
    
    public void agregarPedidosAComanda(String idComanda, List<PedidoDTO> pedidos) throws NegocioException;
}
