/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 * PedidoNuevoDTO. Representa la información necesaria para registrar un pedido
 * de un producto dentro de una comanda en construcción.
 *
 * Este DTO se utiliza para almacenar temporalmente los pedidos antes de generar
 * la comanda final.
 *
 * @author DishUp
 */
public class PedidoNuevoDTO {

    private Integer idProducto;
    private Integer cantidad;
    private String especificaciones;
    private String nombreProducto;

    public PedidoNuevoDTO(Integer idProducto, Integer cantidad, String especificaciones) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.especificaciones = especificaciones;
    }

    public PedidoNuevoDTO() {
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    @Override
    public String toString() {
        String detalles = (especificaciones != null && !especificaciones.isEmpty())
                ? " (" + especificaciones + ")"
                : "";
        return cantidad + " x " + nombreProducto + detalles;
    }

}
