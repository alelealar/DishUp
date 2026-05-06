package BO;

import dto.PedidoNuevoDTO;
import dto.ProductoIngredienteDTO;
import fachada.ProductoFachada;
import infraestructura.InventarioAPI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComandaBO {

    private final InventarioAPI inventarioAPI;

    private final ProductoFachada productoFachada;

    public ComandaBO(ProductoFachada productoFachada) {
        this.productoFachada = productoFachada;
        this.inventarioAPI = new InventarioAPI();
    }

    public boolean procesarComanda(List<PedidoNuevoDTO> pedidos) {

        Map<String, Integer> mapaIngredientes = new HashMap<>();

        for (PedidoNuevoDTO pedido : pedidos) {
            List<ProductoIngredienteDTO> ingredientes
                    = productoFachada.obtenerIngredientesDeProducto(pedido.getIdProducto());

            for (ProductoIngredienteDTO ing : ingredientes) {
                String id = ing.getIdIngrediente();
                int cantidad = ing.getCantidadRequerida();

                mapaIngredientes.put(
                        id,
                        mapaIngredientes.getOrDefault(id, 0) + cantidad
                );
            }
        }

        List<ProductoIngredienteDTO> ingredientesTotales = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : mapaIngredientes.entrySet()) {
            ProductoIngredienteDTO dto = new ProductoIngredienteDTO();
            dto.setIdIngrediente(entry.getKey());
            dto.setCantidadRequerida(entry.getValue());
            ingredientesTotales.add(dto);
        }

        boolean exito = inventarioAPI.descontarStock(pedidos);

        if (!exito) {
            throw new RuntimeException("No hay suficiente stock");
        }

        return true;
    }
}
