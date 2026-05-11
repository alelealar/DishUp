package objetosNegocio;

import adaptadores.ComandaNegocioAdapter;
import daos.ComandaDAO;
import dtos.ComandaDTO;
import dtos.PedidoNuevoDTO;
import dtos_infraestructura.InventarioRequestDTO;
import entidades.Comanda;
import entidades.Pedido;
import enums.EstadoComanda;
import enums.EstadoPedido;
import excepcion.NegocioException;
import excepciones.PersistenciaException;
import fachada.InventarioFachada;
import interfaces.IComandaDAO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ComandaBO {

    private final IComandaDAO comandaDAO;
    private final ComandaNegocioAdapter adapter;
    private final InventarioFachada inventarioAPI;
    private final ProductoBO productoBO;

    public ComandaBO() {
        this.comandaDAO = new ComandaDAO();
        this.adapter = new ComandaNegocioAdapter();
        this.inventarioAPI = new InventarioFachada();
        this.productoBO = new ProductoBO(inventarioAPI);
    }

    public void crearComanda(String nombreCliente, int numeroMesa, List<PedidoNuevoDTO> pedidosDTO) throws NegocioException {        

        if (nombreCliente == null || nombreCliente.isBlank()) {
            throw new NegocioException("Cliente inválido");
        }

        if (pedidosDTO == null || pedidosDTO.isEmpty()) {
            throw new NegocioException("Pedidos vacíos");
        }

        boolean stockOk = procesarComanda(pedidosDTO);

        if (!stockOk) {
            throw new NegocioException("Sin stock suficiente");
        }

        Comanda comanda = new Comanda();
        comanda.setNombreCliente(nombreCliente);
        comanda.setFecha(LocalDateTime.now());
        comanda.setEstado(EstadoComanda.PENDIENTE);

        entidades.Mesa mesa = new entidades.Mesa();
        mesa.setNumero(numeroMesa);
        comanda.setMesa(mesa);

        List<Pedido> pedidos = new ArrayList<>();

        for (PedidoNuevoDTO dto : pedidosDTO) {

            Pedido p = new Pedido();
            p.setIdProducto(dto.getId());
            p.setNombreProducto(dto.getNombreProducto());
            p.setCantidad(dto.getCantidad());
            p.setDescripcion(dto.getEspecificaciones());
            p.setEstado(EstadoPedido.PENDIENTE);
            p.setFechaPedido(LocalDateTime.now());
            p.setPrecioProducto(dto.getPrecioProducto());

            pedidos.add(p);
        }

        comanda.setPedidos(pedidos);

        try {
            comandaDAO.insertarComanda(comanda);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al guardar comanda", e);
        }
    }

    public boolean procesarComanda(List<PedidoNuevoDTO> pedidos) throws NegocioException {

        if (pedidos == null || pedidos.isEmpty()) {
            throw new NegocioException("La lista de pedidos está vacía");
        }

        List<InventarioRequestDTO> inventarioList = new ArrayList<>();

        for (PedidoNuevoDTO pedido : pedidos) {

            if (pedido == null) {
                throw new NegocioException("Pedido inválido");
            }

            productoBO.obtenerIngredientesDeProducto(pedido.getId());

            InventarioRequestDTO dto = new InventarioRequestDTO();

            dto.setIdIngrediente(pedido.getId());
            dto.setCantidad(pedido.getCantidad());

            inventarioList.add(dto);
        }

      //  boolean exito = inventarioAPI.descontarStock(inventarioList);

//        if (!exito) {
//            throw new NegocioException("No hay suficiente stock para procesar la comanda");
//        }

        return true;
    }

    public List<ComandaDTO> obtenerComandasPorMesa(int numeroMesa) {

        try {
            List<Comanda> comandas = comandaDAO.obtenerComandasPorMesa(numeroMesa);
            List<ComandaDTO> listaDTO = new ArrayList<>();

            for (Comanda c : comandas) {
                listaDTO.add(adapter.aDTO(c));
            }

            return listaDTO;

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener comandas", e);
        }
    }
}
