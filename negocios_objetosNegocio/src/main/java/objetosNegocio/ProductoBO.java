package objetosNegocio;

import adaptadores.IngredienteNegocioAdapter;
import adaptadores.ProductoNegocioAdapter;
import dtos.IngredienteEnProductoDTO;
import dtos.ProductoDTO;
import dtos.ProductoIngredienteDTO;
import dtos_infraestructura.ProductoDTOInfraestructura;
import entidades.Producto;
import enums.TipoProducto;
import enums.TipoProductoDTOInfraestructura;
import excepcion.NegocioException;
import excepciones.InfraestructuraException;
import fachada.InventarioFachada;
import java.util.ArrayList;
import java.util.List;

public class ProductoBO {

    private final InventarioFachada fachadaInventario;
    private final ProductoNegocioAdapter productoAdapter;
    private final IngredienteNegocioAdapter ingredienteAdapter;

    public ProductoBO(InventarioFachada fachadaInventario) {
        this.fachadaInventario = fachadaInventario;
        this.productoAdapter = new ProductoNegocioAdapter();
        this.ingredienteAdapter = new IngredienteNegocioAdapter();
    }

    public List<ProductoDTO> obtenerProductosPorTipo(TipoProductoDTOInfraestructura tipo) throws NegocioException {

        if (tipo == null) {
            throw new NegocioException("El tipo de producto es obligatorio.");
        }

        try {

            List<ProductoDTOInfraestructura> productosInfra = fachadaInventario.obtenerProductos();
 
            List<Producto> todos = productoAdapter.listaADominio(productosInfra);

            List<ProductoDTO> filtrados = new ArrayList<>();

            TipoProducto tipoDominio = TipoProducto.valueOf(tipo.name());

            for (Producto producto : todos) {
                if (producto.getTipo() == tipoDominio) {
                    filtrados.add(productoAdapter.aDTO(producto));
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

            ProductoDTOInfraestructura productoInfra = fachadaInventario.obtenerProductoPorId(idProducto);

            Producto producto = productoAdapter.aDominio(productoInfra);

            if (producto == null) {
                return new ArrayList<>();
            }

            return ingredienteAdapter.convertirIngredientesRemovibles(producto.getIngredientes());

        } catch (InfraestructuraException ex) {
            throw new NegocioException("No fue posible obtener los ingredientes.", ex);
        }
    }

    public List<String> obtenerModificadoresRemoviblesPorProducto(String idProducto) throws NegocioException {

        List<IngredienteEnProductoDTO> ingredientes = obtenerIngredientesRemoviblesPorProducto(idProducto);
        
        return ingredienteAdapter.convertirIngredientesAModificadores(ingredientes);
    }

    public List<ProductoIngredienteDTO> obtenerIngredientesDeProducto(String idProducto) throws NegocioException {

        if (idProducto == null || idProducto.isBlank()) {
            throw new NegocioException("El id del producto es obligatorio.");
        }

        try {
            ProductoDTOInfraestructura productoInfra = fachadaInventario.obtenerProductoPorId(idProducto);

            Producto producto = productoAdapter.aDominio(productoInfra);

            if (producto == null) {
                return new ArrayList<>();
            }

            return ingredienteAdapter.convertirAProductoIngredienteDTO(idProducto, producto.getIngredientes());

        } catch (InfraestructuraException ex) {
            throw new NegocioException("No fue posible obtener los ingredientes.", ex);
        }
    }

    public List<ProductoDTO> obtenerProductos() throws NegocioException {

        try {
            List<ProductoDTOInfraestructura> productosInfra = fachadaInventario.obtenerProductos();
            List<Producto> productos = productoAdapter.listaADominio(productosInfra);

            return productoAdapter.listaDominioADTO(productos);

        } catch (InfraestructuraException ex) {
            throw new NegocioException("No fue posible obtener los productos.", ex);
        }
    }
}