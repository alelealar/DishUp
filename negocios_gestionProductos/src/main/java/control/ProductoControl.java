package control;

import dtos.IngredienteEnProductoDTO;
import dtos.ProductoDTO;
import dtos.ProductoIngredienteDTO;
import enums.TipoProductoDTO;
import excepcion.NegocioException;
import excepciones.ProductosException;
import interfaces.ISistemaInventario;
import java.util.ArrayList;
import java.util.List;
import objetosNegocio.ProductoBO;

public class ProductoControl {

    private final ProductoBO productoBO;

    public ProductoControl(ISistemaInventario inventario) {
        this.productoBO = new ProductoBO(inventario);
    }
     /*
    public List<ProductoDTO> obtenerProductos() throws NegocioException {
        return productoBO.obtenerProductos();
    }

    */
    public List<ProductoDTO> obtenerProductosPorTipo(TipoProductoDTO tipo) throws ProductosException {
        try {
            return productoBO.obtenerProductosPorTipo(tipo);
        } catch (NegocioException ex) {
            throw new ProductosException( "No fue posible obtener los productos del tipo seleccionado.");
        }
    }

    public List<IngredienteEnProductoDTO> obtenerIngredientesRemovibles(String idProducto) throws ProductosException {
        try {
            return productoBO.obtenerIngredientesRemoviblesPorProducto(idProducto);
        } catch (NegocioException ex) {
            throw new ProductosException( "No fue posible obtener los ingredientes removibles del producto.");
        }
    }

    public List<ProductoIngredienteDTO> obtenerIngredientesDeProducto(String idProducto) throws ProductosException {
        try {
            return productoBO.obtenerIngredientesDeProducto(idProducto);
        } catch (NegocioException ex) {
            throw new ProductosException( "No fue posible obtener los ingredientes del producto.");
        }
    }

    public List<ProductoDTO> obtenerTodos() throws ProductosException {

        List<ProductoDTO> lista = new ArrayList<>();

        lista.addAll(obtenerProductosPorTipo(TipoProductoDTO.COMIDA));

        lista.addAll(obtenerProductosPorTipo(TipoProductoDTO.BEBIDA));

        lista.addAll(obtenerProductosPorTipo(TipoProductoDTO.BOTANA));

        return lista;
    }
}