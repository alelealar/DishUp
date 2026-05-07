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
    private String id;
    private String nombreCliente;
    private LocalDate fecha;
    private Double total;
    private List<PedidoDTO> listaPedidos;
    private Integer idMesa;

    public ComandaDTO( String nombreCliente, LocalDate fecha, List<PedidoDTO> listaPedidos, Integer idMesa) {
       
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.listaPedidos = listaPedidos;
        this.idMesa = idMesa;
    }

    public ComandaDTO() {
    }
    
    public void calcularTotal(){
        int cantidadProductos = listaPedidos.size();
        double resultado = cantidadProductos*100;
        setTotal(resultado);
    }
    
   

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<PedidoDTO> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<PedidoDTO> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public Integer getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }
    
    
    
    
}
