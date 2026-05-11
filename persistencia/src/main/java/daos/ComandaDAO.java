package daos;

import adaptadores.ComandaPersistenciaAdapter;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import conexion.ConexionMongo;
import entidades.Comanda;
import entidades.Pedido;
import entidadesMongo.ComandaEntidadMongo;
import excepciones.PersistenciaException;
import interfaces.IComandaDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

public class ComandaDAO implements IComandaDAO {

    private final MongoCollection<ComandaEntidadMongo> coleccion;
    private final ComandaPersistenciaAdapter adapter;

    public ComandaDAO() {
        this.coleccion = ConexionMongo.obtenerBaseDatos()
                .getCollection("comandas", ComandaEntidadMongo.class);
        this.adapter = new ComandaPersistenciaAdapter();
    }

    @Override
    public Comanda insertarComanda(Comanda comanda) throws PersistenciaException {

        if (comanda == null) {
            throw new PersistenciaException("Comanda nula");
        }

        try {
            ComandaEntidadMongo mongo = adapter.aMongo(comanda);

            InsertOneResult result = coleccion.insertOne(mongo);

            if (result.getInsertedId() == null) {
                throw new PersistenciaException("Error al insertar comanda");
            }

            String id = result.getInsertedId()
                    .asObjectId()
                    .getValue()
                    .toHexString();

            mongo.setId(id);

            return adapter.aDominio(mongo);

        } catch (MongoException e) {
            throw new PersistenciaException("Error Mongo insertar comanda", e);
        }
    }

    @Override
    public List<Comanda> obtenerTodas() throws PersistenciaException {

        try {
            List<ComandaEntidadMongo> listaMongo = coleccion.find().into(new ArrayList<>());               

            List<Comanda> lista = new ArrayList<>();

            for (ComandaEntidadMongo m : listaMongo) {
                lista.add(adapter.aDominio(m));
            }

            return lista;

        } catch (MongoException e) {
            throw new PersistenciaException("Error al obtener comandas", e);
        }
    }

    @Override
    public List<Comanda> obtenerComandasPorMesa(int numeroMesa) throws PersistenciaException {

        try {
            List<ComandaEntidadMongo> listaMongo = coleccion.find(eq("mesa.numero", numeroMesa)).into(new ArrayList<>());

            List<Comanda> lista = new ArrayList<>();

            for (ComandaEntidadMongo m : listaMongo) {
                lista.add(adapter.aDominio(m));
            }

            return lista;

        } catch (MongoException e) {
            throw new PersistenciaException("Error al consultar comandas", e);
        }
    }

    @Override
    public Comanda obtenerPorId(String id) throws PersistenciaException {

        try {
            ComandaEntidadMongo mongo =
                    coleccion.find(eq("_id", new ObjectId(id))).first();

            return adapter.aDominio(mongo);

        } catch (MongoException e) {
            throw new PersistenciaException("Error al buscar comanda", e);
        }
    }

    @Override
    public boolean actualizarEstado(String idComanda, String nuevoEstado) throws PersistenciaException {

        try {
            UpdateResult result = coleccion.updateOne(
                    eq("_id", new ObjectId(idComanda)),
                    set("estado", nuevoEstado)
            );

            return result.getModifiedCount() > 0;

        } catch (MongoException e) {
            throw new PersistenciaException("Error al actualizar estado", e);
        }
    }

    @Override
    public boolean agregarPedido(String idComanda, Pedido nuevoPedido) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}