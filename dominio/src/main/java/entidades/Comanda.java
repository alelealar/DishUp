/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enums.EstadoComanda;
import java.time.LocalDateTime;
import java.util.List;
import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonRepresentation;
import org.bson.types.ObjectId;

/**
 *
 * @author valeria
 */
public class Comanda {
    
    @BsonId
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String id;
    private String nombreCliente;
    private LocalDateTime fecha;
    private Double total;
    private EstadoComanda estado;
    private Mesa mesa;
    
    private List<Pedido> pedidos;
    private List<Pago> pagos;

    public Comanda() {
    }

    public Comanda(String id, String nombreCliente, LocalDateTime fecha, Double total, EstadoComanda estado, Mesa mesa, List<Pedido> pedidos, List<Pago> pagos) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
        this.mesa = mesa;
        this.pedidos = pedidos;
        this.pagos = pagos;
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public EstadoComanda getEstado() {
        return estado;
    }

    public void setEstado(EstadoComanda estado) {
        this.estado = estado;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }
}
