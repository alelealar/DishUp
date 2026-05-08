/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package daos;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.InsertOneResult;
import entidadesMongo.Empleado;
import enums.EstadoEmpleado;
import enums.RolEmpleado;
import excepciones.PersistenciaException;
import interfaces.IEmpleadoDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;


/**
 *
 * @author DishUp
 */

public class EmpleadoDAO implements IEmpleadoDAO{
    
    private final MongoCollection<Empleado> coleccion;

    public EmpleadoDAO() {
        this.coleccion = conexion.ConexionMongo.obtenerBaseDatos().getCollection("empleados", Empleado.class);
    }
    
    @Override
    public Empleado insertarEmpleado(Empleado empleado) throws PersistenciaException{
        if(empleado == null){
            throw new PersistenciaException("El empleado es nulo");
        }
        
        try{
            InsertOneResult resultado = this.coleccion.insertOne(empleado);
            if (resultado.getInsertedId() == null) {
                throw new PersistenciaException("Error al guardar");
            }
            String idGenerado = resultado.getInsertedId().asObjectId().getValue().toHexString();
            empleado.setId(idGenerado);
            return empleado; 
        } catch (MongoException me) {
            throw new PersistenciaException(me.getMessage());
        }  
    }

    @Override
    public Empleado obtenerEmpleado(Empleado empleado) throws PersistenciaException {
        if(empleado == null){
            throw new PersistenciaException("El empleado es nulo");
        }
        
        if (empleado.getId() == null || empleado.getId().isBlank()) {
            throw new PersistenciaException("El ID del empleado es inválido");
        }

        return this.coleccion.find(eq("_id", new ObjectId(empleado.getId()))).first();
    }
    
    @Override
    public Empleado obtenerEmpleadoPorUser(String user) throws PersistenciaException {
        if(user == null){
            throw new PersistenciaException("El usuario es nulo");
        }

        return coleccion.find(eq("user", user)).first();
    }

    @Override
    public void actualizarEstadoEmpleado(String id, EstadoEmpleado estado) throws PersistenciaException{
        if (id == null || id.isBlank()) {
            throw new PersistenciaException("ID inválido");
        }

        if (estado == null) {
            throw new PersistenciaException("Estado inválido");
        }
        
        coleccion.updateOne(eq("_id", new ObjectId(id)), set("estado", estado));
    }
    
}
