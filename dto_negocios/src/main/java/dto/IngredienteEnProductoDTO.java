/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dto;


/**
 *
 * @author Alejandra Leal Armenta, 262719
 */

public class IngredienteEnProductoDTO {
    private String nombre;
    private int cantidad;
    private boolean removible;

    public IngredienteEnProductoDTO(String nombre, int cantidad, boolean removible) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.removible = removible;
    }

    public IngredienteEnProductoDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isRemovible() {
        return removible;
    }

    public void setRemovible(boolean removible) {
        this.removible = removible;
    }
    
    
}
