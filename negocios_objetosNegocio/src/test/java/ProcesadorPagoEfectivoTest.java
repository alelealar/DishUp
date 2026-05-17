/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import dtos.ResultadoPagoDTO;
import dtos.SolicitudPagoDTO;
import entidades.DetallePagoEfectivo;
import enums.MetodoPago;
import excepcion.NegocioException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import procesadores.ProcesadorPagoEfectivo;

/**
 *
 * @author valeria
 */
public class ProcesadorPagoEfectivoTest {
    
    public ProcesadorPagoEfectivoTest() {
    }

    @Test
    public void testProcesarPagoEfectivoAprobado() throws Exception {

        ProcesadorPagoEfectivo procesador = new ProcesadorPagoEfectivo();

        DetallePagoEfectivo detalle = new DetallePagoEfectivo(
                200,
                0
        );

        SolicitudPagoDTO solicitud = new SolicitudPagoDTO(
                "idComanda123",
                MetodoPago.EFECTIVO,
                150,
                detalle
        );

        ResultadoPagoDTO resultado = procesador.procesarPago(solicitud);

        assertTrue(resultado.isAprobado());
        assertEquals(MetodoPago.EFECTIVO, resultado.getMetodoPago());
        assertEquals(150, resultado.getMontoPagado(), 0.01);
        assertNotNull(resultado.getDetallePago());

        DetallePagoEfectivo detalleResultado =
                (DetallePagoEfectivo) resultado.getDetallePago();

        assertEquals(200, detalleResultado.getMontoRecibido(), 0.01);
        assertEquals(50, detalleResultado.getCambio(), 0.01);
    }

    @Test
    public void testProcesarPagoEfectivoMontoInsuficiente() {

        ProcesadorPagoEfectivo procesador = new ProcesadorPagoEfectivo();

        DetallePagoEfectivo detalle = new DetallePagoEfectivo(
                100,
                0
        );

        SolicitudPagoDTO solicitud = new SolicitudPagoDTO(
                "idComanda123",
                MetodoPago.EFECTIVO,
                150,
                detalle
        );

        assertThrows(NegocioException.class, () -> {
            procesador.procesarPago(solicitud);
        });
    }
}
