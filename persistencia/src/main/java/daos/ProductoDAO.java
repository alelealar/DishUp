/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package daos;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;
import entidades.Producto;
import enums.TipoProducto;
import interfaces.IProductoDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;


/**
 *
 * @author DishUp
 */

public class ProductoDAO implements IProductoDAO{
    
    private final MongoCollection<Producto> coleccion;

    public ProductoDAO(MongoCollection<Producto> coleccion) { // Se esta pasando la coleccion como parametro pero no lo estamos usando para inicializar la conexión
        this.coleccion = conexion.ConexionMongo.obtenerBaseDatosCodec().getCollection("Productos", Producto.class);
    }
    
    @Override
    public List<Producto> buscar(String nombre, TipoProducto tipo, Boolean disponible){
        List<Bson> filtros = new ArrayList<>();
        
        if(nombre != null && !nombre.isEmpty()){
             filtros.add(regex("nombre", nombre, "i"));
        }
        
        if(tipo != null){
            filtros.add(eq("tipo", tipo));
        }
        
        return coleccion.find(and(filtros)).into(new ArrayList<>());
    }
    
    @Override
    public List<Producto> obtenerProductosPorTipo(TipoProducto tipo){
        return coleccion.find(eq("tipo", tipo)).into(new ArrayList<>());
    }

    @Override
    public Producto obtenerProductoPorId(String id) {
        return coleccion .find(eq("_id", new ObjectId(id))) .first();
    }
    
}
