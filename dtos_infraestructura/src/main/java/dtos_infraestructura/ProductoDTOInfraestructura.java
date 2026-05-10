/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos_infraestructura;

import enums.TipoProductoDTO;
import java.util.List;

/**
 *
 * @author DishUp
 */
public class ProductoDTOInfraestructura {
    private String id;
    private String nombre;
    private float precio;
    private boolean disponible;
    private Integer tiempoPreparacion;
    private TipoProductoDTO tipo;
    private String urlImagen;
    private List<IngredienteDTOInfraestructura> ingredientes;

    public ProductoDTOInfraestructura() {
    }

    public ProductoDTOInfraestructura(String id, String nombre, float precio, boolean disponible, Integer tiempoPreparacion, TipoProductoDTO tipo, String urlImagen, List ingredientes) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.tiempoPreparacion = tiempoPreparacion;
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

    public Integer getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(Integer tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public TipoProductoDTO getTipo() {
        return tipo;
    }

    public void setTipo(TipoProductoDTO tipo) {
        this.tipo = tipo;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public List<IngredienteDTOInfraestructura> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteDTOInfraestructura> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    

}
