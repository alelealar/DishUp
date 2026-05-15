    package objetosNegocio;

    import adaptadores.ComandaNegocioAdapter;
    import daos.ComandaDAO;
    import dtos.ComandaDTO;
    import dtos.EmpleadoDTO;
    import dtos.PedidoDTO;
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

        public void crearComanda(String nombreCliente, int numeroMesa, List<PedidoDTO> pedidosDTO, EmpleadoDTO empleadoActual) throws NegocioException {

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

            Comanda comanda = adapter.aEntidad(
                    nombreCliente,
                    numeroMesa,
                    pedidosDTO,
                    empleadoActual
            );

            List<Pedido> pedidos = new ArrayList<>();

            for (PedidoDTO dto : pedidosDTO) {

                Pedido p = new Pedido();
                p.setIdProducto(dto.getIdProducto());
                p.setNombreProducto(dto.getNombreProducto());
                p.setCantidad(dto.getCantidad());
                p.setDescripcion(dto.getDescripcion());
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

        public boolean procesarComanda(List<PedidoDTO> pedidos) throws NegocioException {

            if (pedidos == null || pedidos.isEmpty()) {
                throw new NegocioException("La lista de pedidos está vacía");
            }

            List<InventarioRequestDTO> inventarioList = new ArrayList<>();

            for (PedidoDTO pedido : pedidos) {

                if (pedido == null) {
                    throw new NegocioException("Pedido inválido");
                }

                productoBO.obtenerIngredientesDeProducto(pedido.getId());

                InventarioRequestDTO dto = new InventarioRequestDTO();

                dto.setIdProducto(pedido.getId());
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

            } catch (PersistenciaException e) {
                throw new RuntimeException("Error al obtener comandas", e);
            }
        }

        public void agregarPedidosAComanda(String idComanda, List<PedidoDTO> pedidosDTO) throws NegocioException {

            if (pedidosDTO == null || pedidosDTO.isEmpty()) {
                throw new NegocioException("Pedidos vacíos");
            }

            boolean stockOk = procesarComanda(pedidosDTO);

            if (!stockOk) {
                throw new NegocioException("Sin stock suficiente");
            }


            try {

                for (PedidoDTO dto : pedidosDTO) {

                    Pedido pedido = new Pedido();

                    pedido.setIdProducto(dto.getIdProducto());
                    pedido.setNombreProducto(dto.getNombreProducto());
                    pedido.setCantidad(dto.getCantidad());
                    pedido.setDescripcion(dto.getDescripcion());
                    pedido.setEstado(EstadoPedido.PENDIENTE);
                    pedido.setFechaPedido(LocalDateTime.now());
                    pedido.setPrecioProducto(dto.getPrecioProducto());

                    boolean ok = comandaDAO.agregarPedidoAComanda(idComanda, pedido);
                    if (!ok) {
                        throw new NegocioException("No se pudo agregar el pedido a la comanda");
                    }
                }

            } catch (PersistenciaException e) {
                throw new NegocioException("Error al agregar pedidos a comanda", e);
            }
        }

        public boolean eliminarComanda(String idComanda) throws NegocioException {

            if (idComanda == null || idComanda.isBlank()) {
                throw new NegocioException("El id de la comanda es inválido");
            }

            try {

                Comanda comanda = comandaDAO.obtenerPorId(idComanda);

                if (comanda == null) {
                    throw new NegocioException("La comanda no existe");
                }
                if (comanda.getEstado() != EstadoComanda.PENDIENTE) {
                    throw new NegocioException("Solo se pueden eliminar comandas en estado PENDIENTE");
                }

                boolean eliminada = comandaDAO.eliminarComanda(idComanda);

                if (!eliminada) {
                    throw new NegocioException("No se pudo eliminar la comanda");
                }

                return true;

            } catch (PersistenciaException e) {
                throw new NegocioException("Error al eliminar la comanda", e);
            }
        }

    }
