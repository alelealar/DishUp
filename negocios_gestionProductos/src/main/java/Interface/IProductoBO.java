/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package Interface;

import dto.ProductoDTO;
import enums.TipoProducto;
import java.util.List;

/**
 *
 * @author DishUp
 */
public interface IProductoBO {

    /**
     * Obtiene una lista de productos filtrados por tipo.
     * @param tipo tipo de producto a filtrar
     * @return lista de productos del tipo indicado
     */
    public List<ProductoDTO> obtenerProductosPorTipo(TipoProducto tipo);
}
