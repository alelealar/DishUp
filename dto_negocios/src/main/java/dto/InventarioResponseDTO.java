/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author DishUp
 */
public class InventarioResponseDTO {

    private boolean exito;
    private String mensaje;
    private int stockActual;

    public InventarioResponseDTO() {
    }

    public InventarioResponseDTO(boolean exito, String mensaje, int stockActual) {
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

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

}
