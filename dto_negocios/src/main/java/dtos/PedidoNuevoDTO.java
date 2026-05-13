/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.time.LocalDateTime;

/**
 * PedidoNuevoDTO. Representa la información necesaria para registrar un pedido
 * de un producto dentro de una comanda en construcción.
 *
 * Este DTO se utiliza para almacenar temporalmente los pedidos antes de generar
 * la comanda final.
 *
 * @author DishUp
 */
public class PedidoNuevoDTO {

    private String id;
    private String nombreProducto;
    private String especificaciones;
    private Integer cantidad;
    private float precioProducto;
    private LocalDateTime fechaPedido;

    public PedidoNuevoDTO(String id, String nombreProducto, String especificaciones, Integer tiempoPreparacion, Integer cantidad, float precioProducto, LocalDateTime fechaPedido) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.especificaciones = especificaciones;
        this.cantidad = cantidad;
        this.precioProducto = precioProducto;
        this.fechaPedido = fechaPedido;
    }

    public PedidoNuevoDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }
    
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }
    
    

    @Override
    public String toString() {
        String detalles = (especificaciones != null && !especificaciones.isEmpty())
                ? " (" + especificaciones + ")"
                : "";
        return nombreProducto + detalles;
    }

}
