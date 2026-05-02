/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package conexion;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author DishUp
 */

public class ConexionMongo {
    private static final String url = "mongodb+srv://dishup_user:DishUp2026@dishupcluster.b37ha6e.mongodb.net/?appName=DishUpCluster";
    private static final String BASE_DATOS = "DishUp";
    
    //cliente (acceso a la bd solo 1 vez)
    private static MongoClient cliente;

    private ConexionMongo() {
    }
    
    public static MongoClient obtenerCliente(){
        if(cliente == null){
            cliente = MongoClients.create(url);
        }
        
        return cliente;
    }
    
    public static MongoDatabase obtenerBaseDatos(){
        return obtenerCliente().getDatabase(BASE_DATOS);
    }
}
