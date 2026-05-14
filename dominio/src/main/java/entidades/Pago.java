/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.EstadoPago;
import enums.MetodoPago;
import java.time.LocalDateTime;

/**
 *
 * @author DishUp
 */
public class Pago {
    private String id;
    private MetodoPago metodoPago;
    private float monto;
    private EstadoPago estadoPago;
    private LocalDateTime fechaPago;
    
    private DetallePago detalles;

    public Pago() {
    }

    public Pago(String id, MetodoPago metodoPago, float monto, EstadoPago estadoPago, LocalDateTime fechaPago, DetallePago detalles) {
        this.id = id;
        this.metodoPago = metodoPago;
        this.monto = monto;
        this.estadoPago = estadoPago;
        this.fechaPago = fechaPago;
        this.detalles = detalles;
    } 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public EstadoPago getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public DetallePago getDetalles() {
        return detalles;
    }

    public void setDetalles(DetallePago detalles) {
        this.detalles = detalles;
    }
}
