    package fachada;

    import BO.ProductoBO;
    import Interface.IProductoBO;
    import dto.IngredienteDTO;
import dto.IngredienteEnProductoDTO;
    import dto.ProductoDTO;
    import enums.TipoProducto;
    import java.util.List;

    /**
     * 
     * @author DishUp
     */
    public class ProductoFachada {

        private final IProductoBO productoBO;

        public ProductoFachada(IProductoBO productoBO) {
            this.productoBO = productoBO;
        }

        /**
         * Obtiene productos filtrados por tipo desde la capa de negocio.
         * @param tipo tipo de producto
         * @return lista de productos filtrados
         */
        public List<ProductoDTO> obtenerProductosPorTipo(TipoProducto tipo) {
            return productoBO.obtenerProductosPorTipo(tipo);
        }

        public List<IngredienteEnProductoDTO> obtenerIngredientesRemovibles(String idProducto) {
            return productoBO.obtenerIngredientesRemoviblesPorProducto(idProducto);
        }
    }
