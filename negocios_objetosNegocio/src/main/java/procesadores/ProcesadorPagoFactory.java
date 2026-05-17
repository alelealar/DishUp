/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package procesadores;

import enums.MetodoPago;
import excepcion.NegocioException;

/**
 *
 * @author valeria
 */
public class ProcesadorPagoFactory {
    
    public static IProcesadorPago crearProcesador(MetodoPago metodo) throws NegocioException {

        switch (metodo) {

            case EFECTIVO:
                return new ProcesadorPagoEfectivo();

            case TARJETA:
                return new ProcesadorPagoTarjeta();

            case CODI:
                return new ProcesadorPagoCodi();

            default:
                throw new NegocioException (
                        "Método no soportado"
                );
        }
    }
    
}
