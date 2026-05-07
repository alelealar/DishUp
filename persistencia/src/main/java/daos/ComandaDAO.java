/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import entidades.Comanda;
import entidades.Pedido;
import excepciones.PersistenciaException;
import interfaces.IComandaDAO;
import org.bson.types.ObjectId;
import org.bson.conversions.Bson;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author valeria
 */
public class ComandaDAO implements IComandaDAO {

    private final MongoCollection<Comanda> coleccion;

    public ComandaDAO() {
        this.coleccion = conexion.ConexionMongo.obtenerBaseDatos().getCollection("comandas", Comanda.class);
    }

    @Override
    public boolean agregarPedido(String idComanda, Pedido nuevoPedido) throws PersistenciaException {
        try {
            Bson filtro = Filters.eq("_id", new ObjectId(idComanda));
            Bson operacion = Updates.push("pedidos", nuevoPedido);

            UpdateResult resultado = coleccion.updateOne(filtro, operacion);
            return resultado.getModifiedCount() > 0;
        } catch (Exception e) {
            throw new PersistenciaException("No se pudo agregar el pedido: " + e.getMessage());
        }
    }

    @Override
    public Comanda insertarComanda(Comanda comanda) throws PersistenciaException {
        if (comanda == null) {
            throw new PersistenciaException("La comanda es nula");
        }
        try {
            InsertOneResult resultado = this.coleccion.insertOne(comanda);

            if (resultado.getInsertedId() == null) {
                throw new PersistenciaException("Error al guardar la comanda");
            }
            String idGenerado = resultado.getInsertedId().asObjectId().getValue().toHexString();

            comanda.setId(idGenerado);

            return comanda;
        } catch (MongoException me) {
            throw new PersistenciaException("Error de base de datos: " + me.getMessage());
        }
    }

    @Override
    public List<Comanda> obtenerTodas() throws PersistenciaException {

        try {

            return coleccion.find().into(new ArrayList<>());

        } catch (MongoException e) {

            throw new PersistenciaException("Error al obtener comandas");
        }
    }

    @Override
    public List<Comanda> obtenerComandasPorMesa(int numeroMesa) throws PersistenciaException {
        try {
            Bson filtro = Filters.eq("mesa.numero", numeroMesa);

            return coleccion.find(filtro).into(new ArrayList<>());

        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener comandas: " + e.getMessage());
        }
    }

    @Override
    public Comanda obtenerPorId(String id) throws PersistenciaException {

        try {

            return coleccion.find(Filters.eq("_id", new ObjectId(id))).first();

        } catch (Exception e) {

            throw new PersistenciaException("Error al buscar la comanda");
        }
    }

    @Override
    public boolean actualizarEstado(String idComanda, String nuevoEstado) throws PersistenciaException {

        try {

            Bson filtro = Filters.eq("_id", new ObjectId(idComanda));

            Bson update = Updates.set(
                    "estado",
                    nuevoEstado
            );

            UpdateResult resultado = coleccion.updateOne(filtro, update);

            return resultado.getModifiedCount() > 0;

        } catch (Exception e) {

            throw new PersistenciaException("Error al actualizar estado");
        }
    }
}
