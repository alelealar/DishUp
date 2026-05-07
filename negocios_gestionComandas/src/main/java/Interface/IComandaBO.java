/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import dto.ComandaDTO;
import dto.PedidoNuevoDTO;
import java.util.List;

/**
 *
 * @author DishUp
 */
public interface IComandaBO {
    
        public void crearComanda(String nombreCliente, int numeroMesa, List<PedidoNuevoDTO> pedidosDTO);
        
        public List<ComandaDTO> obtenerComandasPorMesa(int numeroMesa);
}
