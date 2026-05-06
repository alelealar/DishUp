/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package daos;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.InsertOneResult;
import entidades.Mesa;
import excepciones.PersistenciaException;
import interfaces.IMesaDAO;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author DishUp
 */

public class MesaDAO implements IMesaDAO{
    private final MongoCollection<Mesa> coleccion;

    public MesaDAO() {
        this.coleccion = conexion.ConexionMongo.obtenerBaseDatos().getCollection("mesas", Mesa.class);
    }

    @Override
    public List<Mesa> obtenerMesasPorMesero(String idMesero) {
        if (idMesero == null || idMesero.isBlank()) {
            return new ArrayList<>();
        }
        
        return coleccion.find(eq("idMesero", idMesero)).into(new ArrayList<>());
    }

    @Override
    public Mesa insertarMesa(Mesa mesa) throws PersistenciaException{
        if(mesa == null){
            throw new PersistenciaException("La mesa es nula");
        }
        
        try{
            InsertOneResult resultado = this.coleccion.insertOne(mesa);
            if (resultado.getInsertedId() == null) {
                throw new PersistenciaException("Error al guardar");
            }
            String idGenerado = resultado.getInsertedId().asObjectId().getValue().toHexString();
            
            mesa.setId(idGenerado);
            return mesa;
        } catch (MongoException me) {
            throw new PersistenciaException(me.getMessage());
        }  
    }

}
