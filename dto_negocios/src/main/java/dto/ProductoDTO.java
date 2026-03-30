/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dto;

import enums.TipoProducto;


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
    private Integer id;
    private String nombre;
    private Double precio;
    private boolean disponible;
    private Integer tiempoPreparacion;
    private TipoProducto tipo;
    private String urlImagen;

    public ProductoDTO(Integer id, String nombre, Double precio, boolean disponible, Integer tiempoPreparacion, TipoProducto tipo, String urlImagen) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
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

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }
    
    
}
