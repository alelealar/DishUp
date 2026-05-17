/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import dtos.ResultadoPagoDTO;
import dtos.SolicitudPagoDTO;
import excepcion.NegocioException;
import excepciones.PagosException;
import objetosNegocio.PagoBO;

/**
 *
 * @author valeria
 */
public class PagoControl {
    private final PagoBO pagoBO;

    public PagoControl() {
        this.pagoBO = new PagoBO();
    }

    public boolean puedePagarMesa(int numeroMesa) throws PagosException {
        try {
            return pagoBO.puedePagarMesa(numeroMesa);
        } catch(NegocioException ex) {
            throw new PagosException("Ocurrio un error al evaluar si se puede pagar la mesa: " +ex.getMessage());
        }
        
    }

    public boolean puedePagarComanda(String idComanda) throws PagosException {
        try {
            return pagoBO.puedePagarComanda(idComanda);
        } catch(NegocioException ex){
            throw new PagosException("Ocurrio un error al evaluar si se puede pagar la comanda: "+ex.getMessage());
        }
    }
    
    public ResultadoPagoDTO registrarPago(SolicitudPagoDTO solicitud) throws PagosException {
        try {
            return pagoBO.registrarPago(solicitud);
        } catch (NegocioException ex){
            throw new PagosException("Ocurrio un error al intentar si se puede pagar: "+ex.getMessage());
        }
        
    }
    
}
