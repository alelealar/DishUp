package fachada;

import control.ProductoControl;
import dtos.IngredienteEnProductoDTO;
import dtos.ProductoDTO;
import dtos.ProductoIngredienteDTO;
import enums.TipoProductoDTOInfraestructura;
import excepcion.NegocioException;
import excepciones.ProductosException;
import interfaces.ISistemaInventario;
import interfaz.IGestionProductos;
import java.util.List;

public class ProductoFachada implements IGestionProductos{

    private final ProductoControl productoControl;

    public ProductoFachada() {
        ISistemaInventario inventario = new InventarioFachada();
        this.productoControl = new ProductoControl(inventario);
    }

    @Override
    public List<ProductoDTO> obtenerProductos() throws ProductosException {
        try {
            return productoControl.obtenerProductos();
        } catch (NegocioException ex) {
            throw new ProductosException( "No fue posible obtener la lista de productos.");
        }
    }

    @Override
    public List<ProductoDTO> obtenerProductosPorTipo(TipoProductoDTOInfraestructura tipo) throws ProductosException {
        return productoControl.obtenerProductosPorTipo(tipo);
    }

    @Override
    public List<IngredienteEnProductoDTO> obtenerIngredientesRemovibles(String idProducto) throws ProductosException {
        return productoControl.obtenerIngredientesRemovibles(idProducto);
    }

    @Override
    public List<ProductoIngredienteDTO> obtenerIngredientesDeProducto(String idProducto) throws ProductosException {
        return productoControl.obtenerIngredientesDeProducto(idProducto);
    }

    @Override
    public List<ProductoDTO> obtenerTodos() throws ProductosException {
        return productoControl.obtenerTodos();
    }
}