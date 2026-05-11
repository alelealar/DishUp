package adaptadores;

import dtos.ProductoDTO;
import dtos.IngredienteEnProductoDTO;
import dtos_infraestructura.IngredienteDTOInfraestructura;
import dtos_infraestructura.ProductoDTOInfraestructura;
import entidades.IngredienteEnProducto;
import entidades.Producto;
import enums.TipoProducto;
import enums.TipoProductoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * Adapter encargado de convertir productos entre
 * infraestructura, dominio y DTOs de aplicación.
 * 
 * @author DishUp
 */
public class ProductoNegocioAdapter {

    public ProductoNegocioAdapter() {
    }

    public Producto aDominio(ProductoDTOInfraestructura dto) {

        if (dto == null) {
            return null;
        }

        Producto producto = new Producto();

        producto.setId(dto.getId());
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setDisponible(dto.isDisponible());
        producto.setTiempoPreparacion(dto.getTiempoPreparacion());
        producto.setTipo(TipoProducto.valueOf(dto.getTipo().name()));
        producto.setUrlImagen(dto.getUrlImagen());

        List<IngredienteEnProducto> ingredientes = new ArrayList<>();

        if (dto.getIngredientes() != null) {
            for (IngredienteDTOInfraestructura ing : dto.getIngredientes()) {

                IngredienteEnProducto ingrediente = new IngredienteEnProducto();

                ingrediente.setNombre(ing.getNombre());
                ingrediente.setCantidad(ing.getCantidad());
                ingrediente.setRemovible(ing.isRemovible());

                ingredientes.add(ingrediente);
            }
        }

        producto.setIngredientes(ingredientes);

        return producto;
    }

    public List<Producto> listaADominio(List<ProductoDTOInfraestructura> listaDTO) {

        List<Producto> productos = new ArrayList<>();

        if (listaDTO == null) {
            return productos;
        }

        for (ProductoDTOInfraestructura dto : listaDTO) {
            productos.add(aDominio(dto));
        }

        return productos;
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
}