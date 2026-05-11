package control;

import dtos.IngredienteEnProductoDTO;
import dtos.ProductoDTO;
import dtos.ProductoIngredienteDTO;
import enums.TipoProductoDTOInfraestructura;
import excepcion.NegocioException;
import fachada.InventarioFachada;
import java.util.ArrayList;
import java.util.List;
import objetosNegocio.ProductoBO;

public class ProductoControl {

    private final ProductoBO productoBO;

    public ProductoControl() {
        this.productoBO = new ProductoBO((InventarioFachada) new InventarioFachada());
    }

    public List<ProductoDTO> obtenerProductos() throws NegocioException {
        return productoBO.obtenerProductos();
    }

    public List<ProductoDTO> obtenerProductosPorTipo(TipoProductoDTOInfraestructura tipo) throws NegocioException {
        return productoBO.obtenerProductosPorTipo(tipo);
    }

    public List<IngredienteEnProductoDTO> obtenerIngredientesRemovibles(String idProducto) throws NegocioException {
        return productoBO.obtenerIngredientesRemoviblesPorProducto(idProducto);
    }

    public List<ProductoIngredienteDTO> obtenerIngredientesDeProducto(String idProducto) throws NegocioException {
        return productoBO.obtenerIngredientesDeProducto(idProducto);
    }

    public List<ProductoDTO> obtenerTodos() throws NegocioException {

        List<ProductoDTO> lista = new ArrayList<>();

        lista.addAll(obtenerProductosPorTipo(TipoProductoDTOInfraestructura.COMIDA));

        lista.addAll(obtenerProductosPorTipo(TipoProductoDTOInfraestructura.BEBIDA));

        lista.addAll(obtenerProductosPorTipo(TipoProductoDTOInfraestructura.BOTANA));

        return lista;
    }
}