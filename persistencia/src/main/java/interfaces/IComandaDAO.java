package interfaces;

import entidades.Comanda;
import excepciones.PersistenciaException;
import java.util.List;

public interface IComandaDAO {

    Comanda insertarComanda(Comanda comanda) throws PersistenciaException;

    List<Comanda> obtenerTodas() throws PersistenciaException;

    List<Comanda> obtenerComandasPorMesa(int numeroMesa) throws PersistenciaException;

    Comanda obtenerPorId(String id) throws PersistenciaException;

    boolean actualizarEstado(String idComanda, String nuevoEstado) throws PersistenciaException;

    boolean agregarPedido(String idComanda, entidades.Pedido nuevoPedido) throws PersistenciaException;
}
