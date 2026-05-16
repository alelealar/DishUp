package objetosNegocio;

import adaptadores.ComandaNegocioAdapter;
import adaptadores.PedidoNegocioAdapter;
import daos.ComandaDAO;
import dtos.ComandaDTO;
import dtos.EmpleadoDTO;
import dtos.PedidoDTO;
import dtos_infraestructura.InventarioRequestDTO;
import entidades.Comanda;
import entidades.Pedido;
import enums.EstadoComanda;
import excepcion.NegocioException;
import excepciones.PersistenciaException;
import fachada.InventarioFachada;
import interfaces.IComandaDAO;
import java.util.ArrayList;
import java.util.List;

public class ComandaBO {

    private final IComandaDAO comandaDAO;
    private final ComandaNegocioAdapter adapter;
    private final PedidoNegocioAdapter pedidoAdapter;
    private final InventarioFachada inventarioAPI;
    private final ProductoBO productoBO;

    public ComandaBO() {
        this.comandaDAO = new ComandaDAO();
        this.adapter = new ComandaNegocioAdapter();
        this.pedidoAdapter = new PedidoNegocioAdapter();
        this.inventarioAPI = new InventarioFachada();
        this.productoBO = new ProductoBO(inventarioAPI);
    }

    public void crearComanda(String nombreCliente, int numeroMesa,
            List<PedidoDTO> pedidosDTO, EmpleadoDTO empleadoActual) throws NegocioException {
        procesarComanda(pedidosDTO);
        Comanda comanda = adapter.aEntidad(nombreCliente, numeroMesa, pedidosDTO, empleadoActual);
        try {
            comandaDAO.insertarComanda(comanda);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al guardar comanda", e);
        }
    }

    public void procesarComanda(List<PedidoDTO> pedidos) throws NegocioException {
        List<InventarioRequestDTO> inventarioList = new ArrayList<>();
        for (PedidoDTO pedido : pedidos) {
            productoBO.obtenerIngredientesDeProducto(pedido.getIdProducto());
            InventarioRequestDTO dto = new InventarioRequestDTO();
            dto.setIdProducto(pedido.getIdProducto());
            dto.setCantidad(pedido.getCantidad());
            inventarioList.add(dto);
        }
        // inventarioAPI.descontarStock(inventarioList); 
    }

    public List<ComandaDTO> obtenerComandasPorMesa(int numeroMesa) {
        try {
            List<Comanda> comandas = comandaDAO.obtenerComandasPorMesa(numeroMesa);
            List<ComandaDTO> listaDTO = new ArrayList<>();
            for (Comanda c : comandas) listaDTO.add(adapter.aDTO(c));
            return listaDTO;
        } catch (PersistenciaException e) {
            throw new RuntimeException("Error al obtener comandas", e);
        }
    }

    public void agregarPedidosAComanda(String idComanda, List<PedidoDTO> pedidosDTO) throws NegocioException {
        procesarComanda(pedidosDTO);
        List<Pedido> pedidos = pedidoAdapter.listaAEntidad(pedidosDTO);
        try {
            for (Pedido pedido : pedidos) {
                boolean ok = comandaDAO.agregarPedidoAComanda(idComanda, pedido);
                if (!ok) throw new NegocioException("No se pudo agregar el pedido");
            }
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar pedidos", e);
        }
    }

    public void actualizarComanda(ComandaDTO comandaDTO) throws NegocioException {
        List<Pedido> pedidos = pedidoAdapter.listaAEntidad(comandaDTO.getPedidos());
        try {
            comandaDAO.actualizarComanda(comandaDTO.getId(), pedidos);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al actualizar comanda", e);
        }
    }

    public boolean eliminarComanda(String idComanda) throws NegocioException {
        try {
            boolean eliminada = comandaDAO.eliminarComanda(idComanda);
            if (!eliminada) throw new NegocioException("No se pudo eliminar la comanda");
            return true;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al eliminar la comanda", e);
        }
    }

    public List<ComandaDTO> obtenerComandasListas() throws NegocioException {
        try {
            List<Comanda> comandas = comandaDAO.obtenerComandasListas();
            List<ComandaDTO> listaDTO = new ArrayList<>();
            for (Comanda c : comandas) listaDTO.add(adapter.aDTO(c));
            return listaDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener comandas listas", e);
        }
    }

    public void entregarComanda(String idComanda) throws NegocioException {
        try {
            boolean actualizado = comandaDAO.actualizarEstado(idComanda, EstadoComanda.ENTREGADA.name());
            if (!actualizado) throw new NegocioException("No se pudo actualizar");
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al entregar comanda", e);
        }
    }

    public ComandaDTO obtenerComandaPorId(String id) throws NegocioException {
        try {
            Comanda comanda = comandaDAO.obtenerPorId(id);
            if (comanda == null) return null;
            return adapter.aDTO(comanda);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener comanda", e);
        }
    }
}