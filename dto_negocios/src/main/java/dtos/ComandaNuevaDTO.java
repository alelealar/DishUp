/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dtos;

import java.util.List;


/**
 * ComandaNuevaDTO.
 * Representa la informacion necesaria para registrar una comanda.
 * 
 * Este DTO encapsula los datos generales de la comanda, asi como la
 * coleccion de pedidos generados en memoria para al final ser asociados a la
 * comanda al momento de registrarse.
 * 
 * @author DishUp
 */

public class ComandaNuevaDTO {
    private String nombreCliente;
    private Integer idMesa;
    private List<PedidoNuevoDTO> listaPedidos;

    public ComandaNuevaDTO(String nombreCliente, Integer idMesa, List<PedidoNuevoDTO> listaPedidos) {
        this.nombreCliente = nombreCliente;
        this.idMesa = idMesa;
        this.listaPedidos = listaPedidos;
    }

    public ComandaNuevaDTO() {
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Integer getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public List<PedidoNuevoDTO> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<PedidoNuevoDTO> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
    
    
}
