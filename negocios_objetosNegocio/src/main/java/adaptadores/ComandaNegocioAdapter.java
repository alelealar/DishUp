package adaptadores;

import dtos.ComandaDTO;
import dtos.PedidoDTO;
import entidades.Comanda;
import entidades.Pedido;
import java.util.ArrayList;
import java.util.List;

public class ComandaNegocioAdapter {

    public ComandaNegocioAdapter() {
    }

    public ComandaDTO aDTO(Comanda comanda) {

        if (comanda == null) {
            return null;
        }

        ComandaDTO dto = new ComandaDTO();

        dto.setId(comanda.getId());
        dto.setNombreCliente(comanda.getNombreCliente());

        if (comanda.getFecha() != null) {
            dto.setFecha(comanda.getFecha().toLocalDate());
        }

        dto.setTotal(comanda.getTotal());

        if (comanda.getMesa() != null) {
            dto.setIdMesa(comanda.getMesa().getNumero());
        }

        List<PedidoDTO> pedidosDTO = new ArrayList<>();

        if (comanda.getPedidos() != null) {

            for (Pedido pedido : comanda.getPedidos()) {

                PedidoDTO pedidoDTO = new PedidoDTO();

                pedidoDTO.setId(pedido.getId());
                pedidoDTO.setId(pedido.getIdProducto());

                pedidoDTO.setNombreProducto(pedido.getNombreProducto());
                pedidoDTO.setCantidad(pedido.getCantidad());
                pedidoDTO.setDescripcion(pedido.getDescripcion());
                pedidoDTO.setPrecioProducto(pedido.getPrecioProducto());
                pedidoDTO.setTiempoPreparacion(pedido.getTiempoPreparacion());
                pedidoDTO.setFechaPedido(pedido.getFechaPedido());

                pedidosDTO.add(pedidoDTO);
            }
        }

        dto.setPedidos(pedidosDTO);

        return dto;
    }
}
