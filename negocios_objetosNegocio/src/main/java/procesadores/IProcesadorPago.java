/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package procesadores;

import dtos.ResultadoPagoDTO;
import dtos.SolicitudPagoDTO;
import entidades.Pago;
import excepcion.NegocioException;

/**
 *
 * @author valeria
 */
public interface IProcesadorPago {
    ResultadoPagoDTO procesarPago(SolicitudPagoDTO solicitud) throws NegocioException;
}
