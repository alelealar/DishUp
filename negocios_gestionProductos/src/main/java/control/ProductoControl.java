package control;

import fachada.ProductoFachada;
import dto.IngredienteDTO;
import dto.IngredienteEnProductoDTO;
import dto.ProductoDTO;
import enums.TipoProducto;
import java.util.ArrayList;
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

    public ProductoFachada getProductoFachada() {
        return productoFachada;
    }

    public List<ProductoDTO> obtenerProductos() {
        return productoFachada.obtenerProductos();
    }
    
    public List<ProductoDTO> obtenerProductosPorTipo(TipoProducto tipo) {
        return productoFachada.obtenerProductosPorTipo(tipo);
    }

    public List<IngredienteEnProductoDTO> obtenerIngredientesRemovibles(String idProducto) {
        return productoFachada.obtenerIngredientesRemovibles(idProducto);
    }

    public List<ProductoDTO> obtenerTodos() {
        List<ProductoDTO> lista = new ArrayList<>();

        lista.addAll(obtenerProductosPorTipo(TipoProducto.COMIDA));
        lista.addAll(obtenerProductosPorTipo(TipoProducto.BEBIDA));
        lista.addAll(obtenerProductosPorTipo(TipoProducto.BOTANA));

        return lista;
    }
}
