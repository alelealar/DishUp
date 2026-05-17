/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import dtos.ResultadoPagoDTO;
import dtos.SolicitudPagoDTO;
import entidades.DetallePagoTarjeta;
import enums.MetodoPago;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import procesadores.ProcesadorPagoTarjeta;

/**
 *
 * @author valeria
 */
public class ProcesadorPagoTarjetaTest {
    
    public ProcesadorPagoTarjetaTest() {
    }

    @Test
    public void testProcesarPagoTarjetaAprobado() throws Exception {

        ProcesadorPagoTarjeta procesador = new ProcesadorPagoTarjeta();

        SolicitudPagoDTO solicitud = new SolicitudPagoDTO(
                "idComanda123",
                MetodoPago.TARJETA,
                180,
                new DetallePagoTarjeta()
        );

        ResultadoPagoDTO resultado = procesador.procesarPago(solicitud);

        assertTrue(resultado.isAprobado());
        assertEquals(MetodoPago.TARJETA, resultado.getMetodoPago());
        assertEquals(180, resultado.getMontoPagado(), 0.01);
        assertNotNull(resultado.getDetallePago());

        DetallePagoTarjeta detalle =
                (DetallePagoTarjeta) resultado.getDetallePago();

        assertNotNull(detalle.getNumeroAutorizacion());
        assertNotNull(detalle.getUltimos4Digitos());
        assertNotNull(detalle.getBanco());
        assertNotNull(detalle.getTipoTarjeta());
    }
}
