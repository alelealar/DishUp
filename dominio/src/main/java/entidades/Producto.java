/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.TipoProducto;
import java.util.List;

/**
 *
 * @author DishUp
 */
public class Producto {
     private String id;
    private String nombre;
    private float precio;
    private boolean disponible;
    private TipoProducto tipo;
    private String urlImagen;
    private List<IngredienteEnProducto> ingredientes;

    public Producto() {
    }

    public Producto(String id, String nombre, float precio, boolean disponible, TipoProducto tipo, String urlImagen, List<IngredienteEnProducto> ingredientes) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.tipo = tipo;
        this.urlImagen = urlImagen;
        this.ingredientes = ingredientes;
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

    public List<IngredienteEnProducto> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteEnProducto> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
}
