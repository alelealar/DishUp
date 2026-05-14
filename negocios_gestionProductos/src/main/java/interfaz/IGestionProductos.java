package interfaz;

import dtos.ProductoDTO;
import dtos.IngredienteEnProductoDTO;
import dtos.ProductoIngredienteDTO;
import enums.TipoProductoDTOInfraestructura;
import excepcion.NegocioException;
import excepciones.ProductosException;

import java.util.List;

public interface IGestionProductos {

    List<ProductoDTO> obtenerProductos() throws ProductosException;

    List<ProductoDTO> obtenerProductosPorTipo(TipoProductoDTOInfraestructura tipo) throws ProductosException;

    List<IngredienteEnProductoDTO> obtenerIngredientesRemovibles(String idProducto) throws ProductosException;

    List<ProductoIngredienteDTO> obtenerIngredientesDeProducto(String idProducto) throws ProductosException;

    List<ProductoDTO> obtenerTodos() throws ProductosException;
}