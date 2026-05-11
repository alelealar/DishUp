package control;

import dtos.IngredienteEnProductoDTO;
import dtos.ProductoDTO;
import dtos.ProductoIngredienteDTO;
import dtos_infraestructura.ProductoDTOInfraestructura;
import enums.TipoProducto;
import enums.TipoProductoDTO;
import excepcion.NegocioException;
import interfaces.ISistemaInventario;
import inventario.SistemaInventario;
import java.util.ArrayList;
import java.util.List;
import objetosNegocio.ProductoBO;

public class ProductoControl {

    private final ProductoBO productoBO;

    public ProductoControl() {
        this.productoBO = new ProductoBO((ISistemaInventario) new SistemaInventario());
    }

    public List<ProductoDTO> obtenerProductos() throws NegocioException {
        return productoBO.obtenerProductos();
    }

    public List<ProductoDTO> obtenerProductosPorTipo(TipoProductoDTO tipo) throws NegocioException {
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

        lista.addAll(obtenerProductosPorTipo(TipoProductoDTO.COMIDA));

        lista.addAll(obtenerProductosPorTipo(TipoProductoDTO.BEBIDA));

        lista.addAll(obtenerProductosPorTipo(TipoProductoDTO.BOTANA));

        return lista;
    }
}