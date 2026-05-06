/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package daos;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import entidades.Ingrediente;
import interfaces.IIngredienteDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;


/**
 *
 * @author DishUp
 */

public class IngredienteDAO implements IIngredienteDAO{
    
    private final MongoCollection<Ingrediente> coleccion;

    public IngredienteDAO(MongoCollection<Ingrediente> coleccion) {
        this.coleccion = conexion.ConexionMongo.obtenerBaseDatos().getCollection("Ingredientes", Ingrediente.class);
    }

    @Override
    public Ingrediente buscarPorId(String id) {
        return coleccion.find(eq("_id", new ObjectId(id))).first();
    }

    @Override
    public List<Ingrediente> obtenerIngredientes() {
        return coleccion.find().into(new ArrayList<>());
    }
    
}
