/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dto;

import enums.TipoProductoDTO;
import java.util.List;


/**
 * ProductoDTO.
 * Representa la informacion de un producto disponible en el sistema.
 *
 * Este DTO contiene los datos basicos del producto como su identificador, nombre,
 * descripcion, precio y disponibilidad, los cuales se utilizan para generar pedidos
 * y mostrar el catalogo al cliente.
 *
 * @author DishUp
 */

public class ProductoDTO {
    private String id;
    private String nombre;
    private float precio;
    private boolean disponible;
    private Integer tiempoPreparacion;
    private TipoProductoDTO tipo;
    private String urlImagen;

    public ProductoDTO(String id, String nombre, float precio, boolean disponible, Integer tiempoPreparacion, TipoProductoDTO tipo, String urlImagen) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.tiempoPreparacion = tiempoPreparacion;
        this.tipo = tipo;
        this.urlImagen = urlImagen;
    }

    public ProductoDTO() {
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

    public boolean estaDisponible() {
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

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public TipoProductoDTO getTipo() {
        return tipo;
    }

    public void setTipo(TipoProductoDTO tipo) {
        this.tipo = tipo;
    } 
}
