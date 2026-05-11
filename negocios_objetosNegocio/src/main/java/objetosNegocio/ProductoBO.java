package objetosNegocio;

import adaptadores.ProductoNegocioAdapter;
import dtos.IngredienteEnProductoDTO;
import dtos.ProductoDTO;
import dtos.ProductoIngredienteDTO;
import dtos_infraestructura.ProductoDTOInfraestructura;
import entidades.Producto;
import enums.TipoProductoDTO;
import excepcion.NegocioException;
import excepciones.InfraestructuraException;
import interfaces.ISistemaInventario;
import java.util.ArrayList;
import java.util.List;

public class ProductoBO {

    private final ISistemaInventario inventarioAPI;
    private final ProductoNegocioAdapter productoAdapter;

    public ProductoBO(ISistemaInventario inventarioAPI) {
        this.inventarioAPI = inventarioAPI;
        this.productoAdapter = new ProductoNegocioAdapter();
    }

    public List<ProductoDTO> obtenerProductosPorTipo(TipoProductoDTO tipo)throws NegocioException {
        if (tipo == null) {
            throw new NegocioException("El tipo de producto es obligatorio.");
        }

        try {

            List<Producto> todos = inventarioAPI.obtenerProductos();
                    
            List<ProductoDTO> filtrados = new ArrayList<>();
                 
            for (Producto producto : todos) {

                if (producto.getTipo() == tipo) {

                    filtrados.add(productoAdapter.aDTO(producto)
                    );
                }
            }

            return filtrados;

        } catch (InfraestructuraException ex) {

            throw new NegocioException("No fue posible obtener los productos.", ex);
        }
    }

    public List<IngredienteEnProductoDTO> obtenerIngredientesRemoviblesPorProducto(String idProducto) throws NegocioException {       
        if (idProducto == null || idProducto.isBlank()) {

            throw new NegocioException("El id del producto es obligatorio.");
        }

        try {

            Producto producto = inventarioAPI.obtenerProductoPorId(idProducto);

            if (producto == null) {
                return new ArrayList<>();
            }

            return productoAdapter.convertirIngredientesRemovibles(producto.getIngredientes());

        } catch (InfraestructuraException ex) {
            throw new NegocioException("No fue posible obtener los ingredientes.", ex);
        }
    }

    public List<String> obtenerModificadoresRemoviblesPorProducto(String idProducto) throws NegocioException {

        List<IngredienteEnProductoDTO> ingredientes = obtenerIngredientesRemoviblesPorProducto(idProducto);

        return productoAdapter.convertirIngredientesAModificadores(ingredientes);
    }

    public List<ProductoIngredienteDTO> obtenerIngredientesDeProducto(String idProducto) throws NegocioException {

        if (idProducto == null || idProducto.isBlank()) {
            throw new NegocioException("El id del producto es obligatorio.");
        }

        try {
            Producto producto = inventarioAPI.obtenerProductoPorId(idProducto);

            if (producto == null) {
                return new ArrayList<>();
            }

            return productoAdapter.convertirAProductoIngredienteDTO(idProducto,producto.getIngredientes());

        } catch (InfraestructuraException ex) {
            throw new NegocioException("No fue posible obtener los ingredientes.", ex);
        }
    }

    public List<ProductoDTO> obtenerProductos() throws NegocioException {
        try {
            List<Producto> productos = inventarioAPI.obtenerProductos();

            return productoAdapter.listaDominioADTO(productos);

        } catch (InfraestructuraException ex) {
            throw new NegocioException("No fue posible obtener los productos.", ex);
        }
    }
}