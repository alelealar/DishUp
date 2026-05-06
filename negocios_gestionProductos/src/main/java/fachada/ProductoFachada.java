package fachada;

import Interface.IProductoBO;
import dto.IngredienteDTO;
import dto.IngredienteEnProductoDTO;
import dto.ProductoDTO;
import dto.ProductoIngredienteDTO;
import enums.TipoProducto;
import java.util.List;

/**
 *
 * @author DishUp
 */
public class ProductoFachada {

    private final IProductoBO productoBO;

    public ProductoFachada(IProductoBO productoBO) {
        this.productoBO = productoBO;
    }
    
    public List<ProductoDTO> obtenerProductos() {
        return productoBO.obtenerProductos();
    }

    /**
     * Obtiene productos filtrados por tipo desde la capa de negocio.
     *
     * @param tipo tipo de producto
     * @return lista de productos filtrados
     */
    public List<ProductoDTO> obtenerProductosPorTipo(TipoProducto tipo) {
        return productoBO.obtenerProductosPorTipo(tipo);
    }

    public List<IngredienteEnProductoDTO> obtenerIngredientesRemovibles(String idProducto) {
        return productoBO.obtenerIngredientesRemoviblesPorProducto(idProducto);
    }

    public List<ProductoIngredienteDTO> obtenerIngredientesDeProducto(String idProducto) {
        return productoBO.obtenerIngredientesDeProducto(idProducto);
    }
}
