/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos_infraestructura;

/**
 *
 * @author DishUp
 */
public class IngredienteDTOInfraestructura {
    private String nombre;
    private Integer cantidad;
    private boolean removible;

    public IngredienteDTOInfraestructura() {
    }

    public IngredienteDTOInfraestructura(String nombre, Integer cantidad, boolean removible) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.removible = removible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isRemovible() {
        return removible;
    }

    public void setRemovible(boolean removible) {
        this.removible = removible;
    }
}
