/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package daos;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import entidades.Empleado;
import excepciones.PersistenciaException;
import interfaces.IEmpleadoDAO;


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
    
}
