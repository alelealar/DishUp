/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dto;

import java.time.LocalDate;
import java.util.List;


/**
 * ComandaDTO.
 * Representa la informacion de una comanda que ya fue registrada en el sistema.
 *
 * Este DTO contiene los datos principales de la comanda, como su identificador,
 * su estado actual y los pedidos que la conforman, permitiendo consultar
 * o dar seguimiento a su proceso dentro del sistema.
 *
 * @author DishUp
 */

public class ComandaDTO {
    private Integer id;
    private String nombreCliente;
    private LocalDate fecha;
    private Double total;
    private List<PedidoNuevoDTO> listaPedidos;
    private Integer idMesa;

    public ComandaDTO(Integer id, String nombreCliente, LocalDate fecha, Double total, List<PedidoNuevoDTO> listaPedidos, Integer idMesa) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.total = total;
        this.listaPedidos = listaPedidos;
        this.idMesa = idMesa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<PedidoNuevoDTO> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<PedidoNuevoDTO> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public Integer getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }
    
    
}
