/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entidades;

import enums.TipoProducto;
import java.util.List;
import org.bson.codecs.pojo.annotations.BsonProperty;


/**
 *
 * @author DishUp
 */

public class Producto {
    private String id;
    private String nombre;
    private float precio;
    private boolean disponible;
    private int tiempoPreparacion;
    
    @BsonProperty("tipo_producto")
    private TipoProducto tipo;
    
    private String urlImagen;

    private List<ProductoIngrediente> ingredientes;

    public Producto() {
    }

    public Producto(String id, String nombre, float precio, boolean disponible, int tiempoPreparacion, TipoProducto tipo, String urlImagen, List<ProductoIngrediente> ingredientes) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.tiempoPreparacion = tiempoPreparacion;
        this.tipo = tipo;
        this.urlImagen = urlImagen;
        this.ingredientes = ingredientes;
    }

    public Producto(String nombre, float precio, boolean disponible, int tiempoPreparacion, TipoProducto tipo, String urlImagen, List<ProductoIngrediente> ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.tiempoPreparacion = tiempoPreparacion;
        this.tipo = tipo;
        this.urlImagen = urlImagen;
        this.ingredientes = ingredientes;
    }

    public Producto(String id, String nombre, float precio, boolean disponible, int tiempoPreparacion, TipoProducto tipo, String urlImagen) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.tiempoPreparacion = tiempoPreparacion;
        this.tipo = tipo;
        this.urlImagen = urlImagen;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public List<ProductoIngrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<ProductoIngrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    
}
