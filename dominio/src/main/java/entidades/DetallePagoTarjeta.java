/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author valeria
 */
public class DetallePagoTarjeta extends DetallePago {
    private String numeroAutorizacion;
    private String ultimos4Digitos;

    public DetallePagoTarjeta() {
    }

    public DetallePagoTarjeta(String numeroAutorizacion, String ultimos4Digitos) {
        this.numeroAutorizacion = numeroAutorizacion;
        this.ultimos4Digitos = ultimos4Digitos;
    } 

    public String getNumeroAutorizacion() {
        return numeroAutorizacion;
    }

    public void setNumeroAutorizacion(String numeroAutorizacion) {
        this.numeroAutorizacion = numeroAutorizacion;
    }

    public String getUltimos4Digitos() {
        return ultimos4Digitos;
    }

    public void setUltimos4Digitos(String ultimos4Digitos) {
        this.ultimos4Digitos = ultimos4Digitos;
    }
}
