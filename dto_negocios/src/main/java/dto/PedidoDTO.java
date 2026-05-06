/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dto;

import enums.EstadoPedidoDTO;


/**
 * PedidoDTO.
 * Representa la informacion de un pedido ya registrado en el sistema.
 *
 * Este DTO incluye los datos del producto solicitado, la cantidad, el estado del pedido
 * y las especificaciones del cliente, permitiendo dar seguimiento a su preparacion
 * dentro del flujo de cocina.
 *
 * @author DishUp
 */

public class PedidoDTO {
    private Integer id;
    private String nombreProducto;
    private Integer cantidad;
    private EstadoPedidoDTO estado;
    private Integer tiempoPreparacion;

    public PedidoDTO(Integer id, String nombreProducto, Integer cantidad, EstadoPedidoDTO estado, Integer tiempoPreparacion) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.estado = estado;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public PedidoDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public EstadoPedidoDTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedidoDTO estado) {
        this.estado = estado;
    }

    public Integer getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(Integer tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }
    
    
}
