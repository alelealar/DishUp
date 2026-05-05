package control;

import fachada.ProductoFachada;
import dto.IngredienteDTO;
import dto.IngredienteEnProductoDTO;
import dto.ProductoDTO;
import enums.TipoProducto;
import java.util.List;

/**
 * 
 * @author DishUp
 */
public class ProductoControl {

    private final ProductoFachada productoFachada;

    public ProductoControl(ProductoFachada productoFachada) {
        this.productoFachada = productoFachada;
    }
    
    public List<ProductoDTO> obtenerProductosPorTipo(TipoProducto tipo) {
        return productoFachada.obtenerProductosPorTipo(tipo);
    }

    public List<IngredienteEnProductoDTO> obtenerIngredientesRemovibles(String idProducto) {
        return productoFachada.obtenerIngredientesRemovibles(idProducto);
    }
}