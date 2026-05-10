package adaptadores;

import dtos.IngredienteEnProductoDTO;
import dtos.ProductoDTO;
import dtos.ProductoIngredienteDTO;
import entidades.IngredienteEnProducto;
import entidades.Producto;
import enums.TipoProductoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * Adapter encargado de convertir ingredientes y modificadores de productos.
 *
 * @author DishUp
 */
public class ProductoNegocioAdapter {

    public List<IngredienteEnProductoDTO> convertirIngredientesRemovibles(List<IngredienteEnProducto> ingredientes) {

        List<IngredienteEnProductoDTO> removibles = new ArrayList<>();

        if (ingredientes == null) {
            return removibles;
        }

        for (IngredienteEnProducto ingrediente : ingredientes) {

            if (ingrediente != null && ingrediente.isRemovible()) {

                IngredienteEnProductoDTO dto = new IngredienteEnProductoDTO();

                dto.setNombre(
                        ingrediente.getNombre()
                );

                dto.setCantidad(
                        ingrediente.getCantidad()
                );

                dto.setRemovible(
                        ingrediente.isRemovible()
                );

                removibles.add(dto);
            }
        }

        return removibles;
    }

    public List<String> convertirIngredientesAModificadores(List<IngredienteEnProductoDTO> ingredientes) {

        List<String> modificadores = new ArrayList<>();

        if (ingredientes == null) {
            return modificadores;
        }

        for (IngredienteEnProductoDTO ingrediente : ingredientes) {
            if (ingrediente != null) {
                modificadores.add(
                        "Sin " + ingrediente.getNombre().toLowerCase()
                );
            }
        }

        return modificadores;
    }

    public List<ProductoIngredienteDTO> convertirAProductoIngredienteDTO(String idProducto, List<IngredienteEnProducto> ingredientes) {

        List<ProductoIngredienteDTO> lista = new ArrayList<>();

        if (ingredientes == null) {
            return lista;
        }

        for (IngredienteEnProducto ingrediente : ingredientes) {

            if (ingrediente != null) {

                ProductoIngredienteDTO dto = new ProductoIngredienteDTO();

                dto.setIdProducto(Integer.parseInt(idProducto));

                dto.setIdIngrediente(ingrediente.getNombre());

                dto.setCantidadRequerida(ingrediente.getCantidad());

                dto.setRemovible(ingrediente.isRemovible());

                lista.add(dto);
            }
        }

        return lista;
    }

    public List<ProductoDTO> listaDominioADTO(List<Producto> productos) {

        List<ProductoDTO> lista = new ArrayList<>();

        if (productos == null) {
            return lista;
        }

        for (Producto producto : productos) {
            lista.add(aDTO(producto));
        }

        return lista;
    }

    public ProductoDTO aDTO(Producto producto) {

        if (producto == null) {
            return null;
        }

        ProductoDTO dto = new ProductoDTO();

        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        dto.setDisponible(producto.isDisponible());
        dto.setTiempoPreparacion(producto.getTiempoPreparacion());

        dto.setTipo(TipoProductoDTO.valueOf(producto.getTipo().name()));

        dto.setUrlImagen(producto.getUrlImagen());

        List<IngredienteEnProductoDTO> ingredientes = new ArrayList<>();

        if (producto.getIngredientes() != null) {

            for (IngredienteEnProducto ingrediente : producto.getIngredientes()) {

                IngredienteEnProductoDTO dtoIngrediente = new IngredienteEnProductoDTO();

                dtoIngrediente.setNombre(ingrediente.getNombre());

                dtoIngrediente.setCantidad(ingrediente.getCantidad());

                dtoIngrediente.setRemovible(ingrediente.isRemovible());

                ingredientes.add(dtoIngrediente);
            }
        }

        dto.setIngredientes(ingredientes);

        return dto;
    }
}
