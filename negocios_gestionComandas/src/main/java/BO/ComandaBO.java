package BO;

import Interface.IComandaBO;
import daos.ComandaDAO;
import dto.ComandaDTO;
import dto.PedidoDTO;
import dto.PedidoNuevoDTO;
import dto.ProductoIngredienteDTO;
import entidades.Comanda;
import entidades.Mesa;
import entidades.Pedido;
import enums.EstadoComanda;
import enums.EstadoPedido;
import enums.EstadoPedidoDTO;
import excepciones.PersistenciaException;
import fachada.ProductoFachada;
import interfaces.IComandaDAO;
import inventario.InventarioAPI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComandaBO implements IComandaBO {

    private final InventarioAPI inventarioAPI;
    private final ProductoFachada productoFachada;
    private final IComandaDAO comandaDAO;

    public ComandaBO(ProductoFachada productoFachada,
            IComandaDAO comandaDAO) {

        this.productoFachada = productoFachada;
        this.comandaDAO = comandaDAO;
        this.inventarioAPI = new InventarioAPI();
    }

    @Override
    public void crearComanda(String nombreCliente, int numeroMesa, List<PedidoNuevoDTO> pedidosDTO) {

        // Validar/descontar inventario
        boolean exito = procesarComanda(pedidosDTO);

        if (!exito) {
            throw new RuntimeException("No hay suficiente stock");
        }

        // Crear entidad Comanda
        Comanda comanda = new Comanda();
        comanda.setNombreCliente(nombreCliente);
        comanda.setFecha(LocalDateTime.now());
        comanda.setEstado(EstadoComanda.PENDIENTE);

        // Mesa
        Mesa mesa = new Mesa();
        mesa.setNumero(numeroMesa);

        comanda.setMesa(mesa);

        // Pedidos
        List<Pedido> pedidosEntidad = new ArrayList<>();

        for (PedidoNuevoDTO dto : pedidosDTO) {

            Pedido pedido = new Pedido();

            pedido.setIdProducto(dto.getIdProducto());
            pedido.setNombreProducto(dto.getNombreProducto());
            pedido.setDescripcion(dto.getEspecificaciones());
            pedido.setEstado(EstadoPedido.PENDIENTE);
            pedido.setFechaPedido(LocalDateTime.now());
            pedido.setPrecioProducto(dto.getPrecioProducto());

            pedidosEntidad.add(pedido);
        }

        comanda.setPedidos(pedidosEntidad);

        // Guardar en Mongo
        try {
            comandaDAO.insertarComanda(comanda);
        } catch (PersistenciaException e) {
            throw new RuntimeException("Error al guardar la comanda: " + e.getMessage());
        }
    }

    public boolean procesarComanda(List<PedidoNuevoDTO> pedidos) {

        Map<String, Integer> mapaIngredientes = new HashMap<>();

        for (PedidoNuevoDTO pedido : pedidos) {

            List<ProductoIngredienteDTO> ingredientes
                    = productoFachada.obtenerIngredientesDeProducto(
                            pedido.getIdProducto()
                    );

            for (ProductoIngredienteDTO ing : ingredientes) {

                String id = ing.getIdIngrediente();
                int cantidad = ing.getCantidadRequerida();

                mapaIngredientes.put(
                        id,
                        mapaIngredientes.getOrDefault(id, 0) + cantidad
                );
            }
        }

        List<ProductoIngredienteDTO> ingredientesTotales
                = new ArrayList<>();

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

    @Override
    public List<ComandaDTO> obtenerComandasPorMesa(int numeroMesa) {
        try {

            List<Comanda> comandas = comandaDAO.obtenerComandasPorMesa(numeroMesa);

            List<ComandaDTO> listaDTO = new ArrayList<>();

            for (Comanda c : comandas) {

                ComandaDTO dto = new ComandaDTO();

                dto.setId(c.getId());
                dto.setNombreCliente(c.getNombreCliente());
                dto.setFecha(c.getFecha().toLocalDate());
                dto.setIdMesa(c.getMesa().getNumero());

                List<PedidoDTO> pedidosDTO = new ArrayList<>();

                if (c.getPedidos() != null) {

                    for (Pedido p : c.getPedidos()) {

                        PedidoDTO pedidoDTO = new PedidoDTO();

                        pedidoDTO.setId(p.getId());

                        pedidoDTO.setCantidad(p.getCantidad());

                        pedidoDTO.setNombreProducto(p.getNombreProducto());

                        pedidoDTO.setDescripcion(p.getDescripcion());

                        pedidoDTO.setPrecioProducto(p.getPrecioProducto());
                        
                        pedidoDTO.setFechaPedido(p.getFechaPedido());
                        if (p.getEstado() != null) {
                            pedidoDTO.setEstado(
                                    EstadoPedidoDTO.valueOf(
                                            p.getEstado().name()
                                    )
                            );
                        }

                        pedidosDTO.add(pedidoDTO);
                    }
                }

                dto.setListaPedidos(pedidosDTO);

                listaDTO.add(dto);
            }

            return listaDTO;

        } catch (Exception e) {
            throw new RuntimeException(
                    "Error al obtener comandas: " + e.getMessage()
            );
        }
    }
}
