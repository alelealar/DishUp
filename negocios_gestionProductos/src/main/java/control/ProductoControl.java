package control;

import fachada.ProductoFachada;
import dto.IngredienteDTO;
import dto.ProductoDTO;
import enums.TipoProducto;
import java.util.List;

/**
 * 
 * @author DishUp
 */
public class ProductoControl {

    private ProductoFachada productoFachada;

    public ProductoControl() {
        this.productoFachada = new ProductoFachada();
    }

    public List<ProductoDTO> obtenerProductosPorTipo(TipoProducto tipo) {
        return productoFachada.obtenerProductosPorTipo(tipo);
    }

    public List<IngredienteDTO> obtenerIngredientesRemovibles(int idProducto) {
        return productoFachada.obtenerIngredientesRemovibles(idProducto);
    }
}