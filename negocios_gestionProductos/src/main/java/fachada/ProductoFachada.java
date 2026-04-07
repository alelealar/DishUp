/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package fachada;

import BO.ProductoBO;
import Interface.IProductoBO;
import dto.IngredienteDTO;
import dto.ProductoDTO;
import enums.TipoProducto;
import java.util.List;


/**
 *
 * @author DishUp
 */

public class ProductoFachada {
    
    private IProductoBO productoBO;

    public ProductoFachada() {
        this.productoBO = ProductoBO.getInstancia();
    }
    
    /**
     * Obtiene productos filtrados por tipo desde la capa de negocio.
     * @param tipo tipo de producto
     * @return lista de productos filtrados
     */
    public List<ProductoDTO> obtenerProductosPorTipo(TipoProducto tipo) {
        return productoBO.obtenerProductosPorTipo(tipo);
    }
    
    public List<IngredienteDTO> obtenerIngredientesRemovibles(int idProducto) {
        return productoBO.obtenerIngredientesRemoviblesPorProducto(idProducto);
    }
    
}
