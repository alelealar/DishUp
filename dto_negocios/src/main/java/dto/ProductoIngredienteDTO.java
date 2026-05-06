/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author valeria
 */
public class ProductoIngredienteDTO {
    private String id;
    private int idProducto;
    private String idIngrediente;
    private int cantidadRequerida; // Cantidad de unidades
    private boolean removible;

    public ProductoIngredienteDTO() {
    }


    public ProductoIngredienteDTO(String id, int idProducto, String idIngrediente, int cantidadRequerida, boolean removible) {
        this.id = id;
        this.idProducto = idProducto;
        this.idIngrediente = idIngrediente;
        this.cantidadRequerida = cantidadRequerida;
        this.removible = removible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(String idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public int getCantidadRequerida() {
        return cantidadRequerida;
    }

    public void setCantidadRequerida(int cantidadRequerida) {
        this.cantidadRequerida = cantidadRequerida;
    }

    public boolean isRemovible() {
        return removible;
    }

    public void setRemovible(boolean removible) {
        this.removible = removible;
    }
    
}
