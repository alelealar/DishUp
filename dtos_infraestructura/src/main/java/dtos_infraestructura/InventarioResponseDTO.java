/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos_infraestructura;

/**
 *
 * @author DishUp
 */
public class InventarioResponseDTO {
    private boolean exito;
    private String mensaje;
    private Integer stockActual;

    public InventarioResponseDTO() {
    }

    public InventarioResponseDTO(boolean exito, String mensaje, Integer stockActual) {
        this.exito = exito;
        this.mensaje = mensaje;
        this.stockActual = stockActual;
    }

    public boolean isExito() {
        return exito;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getStockActual() {
        return stockActual;
    }

    public void setStockActual(Integer stockActual) {
        this.stockActual = stockActual;
    }
}
