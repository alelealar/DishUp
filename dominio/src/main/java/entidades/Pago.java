/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.EstadoPago;
import enums.MetodoPago;
import java.time.LocalDateTime;
import java.util.Map;

/**
 *
 * @author valeria
 */
public class Pago {
    private String id;
    private LocalDateTime fecha;
    private EstadoPago estado;
    private MetodoPago metodoPago;
    private Map<String, Object> detalles;
    private Double monto;

    public Pago() {
    }

    public Pago(String id, LocalDateTime fecha, EstadoPago estado, MetodoPago metodoPago, Map<String, Object> detalles, Double monto) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.detalles = detalles;
        this.monto = monto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public EstadoPago getEstado() {
        return estado;
    }

    public void setEstado(EstadoPago estado) {
        this.estado = estado;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Map<String, Object> getDetalles() {
        return detalles;
    }

    public void setDetalles(Map<String, Object> detalles) {
        this.detalles = detalles;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
