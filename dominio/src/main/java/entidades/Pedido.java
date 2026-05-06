/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.EstadoPedido;

/**
 *
 * @author valeria
 */
public class Pedido {
    private String id;
    private Integer cantidad;
    private EstadoPedido estado;
    private int tiempoPreparacion;
    private String descripcion;

    public Pedido() {
    }

    public Pedido(String id, Integer cantidad, EstadoPedido estado, int tiempoPreparacion, String descripcion) {
        this.id = id;
        this.cantidad = cantidad;
        this.estado = estado;
        this.tiempoPreparacion = tiempoPreparacion;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
