/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos_infraestructura;

/**
 *
 * @author DishUp
 */
public class InventarioRequestDTO {
    private String idIngrediente;
    private Integer cantidad;

    public InventarioRequestDTO() {
    }

    public InventarioRequestDTO(String idIngrediente, Integer cantidad) {
        this.idIngrediente = idIngrediente;
        this.cantidad = cantidad;
    }

    public String getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(String idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}