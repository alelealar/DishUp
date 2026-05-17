/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import control.PagoControl;
import dtos.ResultadoPagoDTO;
import dtos.SolicitudPagoDTO;
import excepciones.PagosException;
import interfaz.IGestionPagos;

/**
 *
 * @author valeria
 */
public class PagoFachada implements IGestionPagos {
    
    private final PagoControl pagoControl;
    
    public PagoFachada(){
        this.pagoControl = new PagoControl();
    }

    @Override
    public boolean puedePagarComanda(String idComanda) throws PagosException {
        return pagoControl.puedePagarComanda(idComanda);
    }

    @Override
    public boolean puedePagarMesa(int numeroMesa) throws PagosException {
        return pagoControl.puedePagarMesa(numeroMesa);
    }

    @Override
    public ResultadoPagoDTO registrarPago(SolicitudPagoDTO solicitud) throws PagosException {
        return pagoControl.registrarPago(solicitud);
    }
    
}
