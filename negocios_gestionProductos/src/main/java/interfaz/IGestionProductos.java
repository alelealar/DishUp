package interfaz;

import dtos.ProductoDTO;
import dtos.IngredienteEnProductoDTO;
import dtos.ProductoIngredienteDTO;
import dtos_infraestructura.ProductoDTOInfraestructura;
import enums.TipoProductoDTO;
import excepcion.NegocioException;

import java.util.List;

public interface IGestionProductos {

    List<ProductoDTO> obtenerProductos() throws NegocioException;

    List<ProductoDTO> obtenerProductosPorTipo(TipoProductoDTO tipo) throws NegocioException;

    List<IngredienteEnProductoDTO> obtenerIngredientesRemovibles(String idProducto) throws NegocioException;

    List<ProductoIngredienteDTO> obtenerIngredientesDeProducto(String idProducto) throws NegocioException;

    List<ProductoDTO> obtenerTodos() throws NegocioException;
}