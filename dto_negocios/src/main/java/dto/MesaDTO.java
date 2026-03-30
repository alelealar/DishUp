/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dto;

import enums.EstadoMesa;


/**
 *
 * @author DishUp
 */

public class MesaDTO {
    private int idMesa;
    private int numeroMesa;
    private EstadoMesa estado;
    private int idMesero;

    public MesaDTO(int idMesa, int numeroMesa, EstadoMesa estado, int idMesero) {
        this.idMesa = idMesa;
        this.numeroMesa = numeroMesa;
        this.estado = estado;
        this.idMesero = idMesero;
    }

    public MesaDTO() {
    }

        
    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public EstadoMesa getEstado() {
        return estado;
    }

    public void setEstado(EstadoMesa estado) {
        this.estado = estado;
    }

    public int getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(int idMesero) {
        this.idMesero = idMesero;
    }
    
    
}
