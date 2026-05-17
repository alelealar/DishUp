/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;
import entidades.DetallePago;
import enums.MetodoPago;

/**
 *
 * @author valeria
 */
public class SolicitudPagoDTO {
    
    private String idComanda;

    private MetodoPago metodoPago;

    private float monto;

    private DetallePago detallePago;

    public SolicitudPagoDTO() {
    }

    public SolicitudPagoDTO(String idComanda, MetodoPago metodoPago, float monto, DetallePago detallePago) {
        this.idComanda = idComanda;
        this.metodoPago = metodoPago;
        this.monto = monto;
        this.detallePago = detallePago;
    }
    
    public String getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(String idComanda) {
        this.idComanda = idComanda;
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

    public DetallePago getDetallePago() {
        return detallePago;
    }

    public void setDetallePago(DetallePago detallePago) {
        this.detallePago = detallePago;
    }
}
