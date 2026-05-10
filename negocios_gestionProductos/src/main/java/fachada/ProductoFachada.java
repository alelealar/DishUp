package fachada;

import control.ProductoControl;
import dtos.IngredienteEnProductoDTO;
import dtos.ProductoDTO;
import dtos.ProductoIngredienteDTO;
import enums.TipoProducto;
import excepcion.NegocioException;
import java.util.List;

public class ProductoFachada {

    private final ProductoControl productoControl;

    public ProductoFachada() {
        this.productoControl = new ProductoControl();
    }

    public List<ProductoDTO> obtenerProductos() throws NegocioException {
        return productoControl.obtenerProductos();
    }

    public List<ProductoDTO> obtenerProductosPorTipo(TipoProducto tipo) throws NegocioException {
        return productoControl.obtenerProductosPorTipo(tipo);
    }

    public List<IngredienteEnProductoDTO> obtenerIngredientesRemovibles(String idProducto) throws NegocioException {
        return productoControl.obtenerIngredientesRemovibles(idProducto);
    }

    public List<ProductoIngredienteDTO> obtenerIngredientesDeProducto(String idProducto) throws NegocioException {
        return productoControl.obtenerIngredientesDeProducto(idProducto);
    }

    public List<ProductoDTO> obtenerTodos() throws NegocioException {
        return productoControl.obtenerTodos();
    }
}