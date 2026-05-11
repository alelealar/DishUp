package fachada;

import control.ProductoControl;
import dtos.IngredienteEnProductoDTO;
import dtos.ProductoDTO;
import dtos.ProductoIngredienteDTO;
import enums.TipoProductoDTOInfraestructura;
import excepcion.NegocioException;
import interfaz.IGestionProductos;
import java.util.List;

public class ProductoFachada implements IGestionProductos{

    private final ProductoControl productoControl;

    public ProductoFachada() {
        this.productoControl = new ProductoControl();
    }

    @Override
    public List<ProductoDTO> obtenerProductos() throws NegocioException {
        return productoControl.obtenerProductos();
    }

    @Override
    public List<ProductoDTO> obtenerProductosPorTipo(TipoProductoDTOInfraestructura tipo) throws NegocioException {
        return productoControl.obtenerProductosPorTipo(tipo);
    }

    @Override
    public List<IngredienteEnProductoDTO> obtenerIngredientesRemovibles(String idProducto) throws NegocioException {
        return productoControl.obtenerIngredientesRemovibles(idProducto);
    }

    @Override
    public List<ProductoIngredienteDTO> obtenerIngredientesDeProducto(String idProducto) throws NegocioException {
        return productoControl.obtenerIngredientesDeProducto(idProducto);
    }

    @Override
    public List<ProductoDTO> obtenerTodos() throws NegocioException {
        return productoControl.obtenerTodos();
    }
}