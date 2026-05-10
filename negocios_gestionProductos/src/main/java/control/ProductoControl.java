package control;

import dtos.IngredienteEnProductoDTO;
import dtos.ProductoDTO;
import dtos.ProductoIngredienteDTO;
import enums.TipoProducto;
import excepcion.NegocioException;
import inventario.SistemaInventario;
import java.util.ArrayList;
import java.util.List;
import objetosNegocio.ProductoBO;

public class ProductoControl {

    private final ProductoBO productoBO;

    public ProductoControl() {
        this.productoBO = new ProductoBO(new SistemaInventario());
    }

    public List<ProductoDTO> obtenerProductos() throws NegocioException {
        return productoBO.obtenerProductos();
    }

    public List<ProductoDTO> obtenerProductosPorTipo(TipoProducto tipo) throws NegocioException {
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

        lista.addAll(obtenerProductosPorTipo(TipoProducto.COMIDA));

        lista.addAll(obtenerProductosPorTipo(TipoProducto.BEBIDA));

        lista.addAll(obtenerProductosPorTipo(TipoProducto.BOTANA));

        return lista;
    }
}