package interfaz;

import dtos.ProductoDTO;
import dtos.IngredienteEnProductoDTO;
import dtos.ProductoIngredienteDTO;
import enums.TipoProductoDTOInfraestructura;
import excepcion.NegocioException;

import java.util.List;

public interface IGestionProductos {

    List<ProductoDTO> obtenerProductos() throws NegocioException;

    List<ProductoDTO> obtenerProductosPorTipo(TipoProductoDTOInfraestructura tipo) throws NegocioException;

    List<IngredienteEnProductoDTO> obtenerIngredientesRemovibles(String idProducto) throws NegocioException;

    List<ProductoIngredienteDTO> obtenerIngredientesDeProducto(String idProducto) throws NegocioException;

    List<ProductoDTO> obtenerTodos() throws NegocioException;
}