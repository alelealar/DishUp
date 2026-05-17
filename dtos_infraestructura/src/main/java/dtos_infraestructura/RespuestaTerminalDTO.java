/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos_infraestructura;

import enums.Banco;
import enums.TipoTarjeta;

/**
 *
 * @author valeria
 */
public class RespuestaTerminalDTO {
    private boolean aprobado;
    private String mensaje;
    private float monto;
    private String numeroAutorizacion;
    private String ultimos4Digitos;
    private Banco banco;
    private TipoTarjeta tipoTarjeta;

    public RespuestaTerminalDTO() {
    }

    public RespuestaTerminalDTO(boolean aprobado, String mensaje, float monto, String numeroAutorizacion, String ultimos4Digitos, Banco banco, TipoTarjeta tipoTarjeta) {
        this.aprobado = aprobado;
        this.mensaje = mensaje;
        this.monto = monto;
        this.numeroAutorizacion = numeroAutorizacion;
        this.ultimos4Digitos = ultimos4Digitos;
        this.banco = banco;
        this.tipoTarjeta = tipoTarjeta;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
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

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public TipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }
}

