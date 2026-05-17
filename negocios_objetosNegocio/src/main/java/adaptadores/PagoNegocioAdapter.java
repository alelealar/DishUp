/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import dtos.ResultadoPagoDTO;
import entidades.Pago;
import enums.EstadoPagoIndividual;
import java.time.LocalDateTime;


/**
 *
 * @author valeria
 */
public class PagoNegocioAdapter {

    public PagoNegocioAdapter() {
    }
    
    public Pago aEntidad(ResultadoPagoDTO resultado){
        if(resultado == null){
            return null;
        }
        Pago pago = new Pago();
        
        pago.setMetodoPago(resultado.getMetodoPago());
        pago.setMonto(resultado.getMontoPagado());
        pago.setEstadoPago(EstadoPagoIndividual.PAGADO);
        pago.setFechaPago(LocalDateTime.now());
        pago.setDetalles(resultado.getDetallePago());
        
        return pago;
    }
}
