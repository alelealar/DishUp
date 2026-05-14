/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author valeria
 */
public class DetallePagoEfectivo extends DetallePago{
    private float montoRecibido;
    private float cambio;

    public DetallePagoEfectivo() {
    }

    public DetallePagoEfectivo(float montoRecibido, float cambio) {
        this.montoRecibido = montoRecibido;
        this.cambio = cambio;
    }

    public float getMontoRecibido() {
        return montoRecibido;
    }

    public void setMontoRecibido(float montoRecibido) {
        this.montoRecibido = montoRecibido;
    }

    public float getCambio() {
        return cambio;
    }

    public void setCambio(float cambio) {
        this.cambio = cambio;
    }
    
}
