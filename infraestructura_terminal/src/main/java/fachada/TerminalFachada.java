/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import dtos_infraestructura.RespuestaTerminalDTO;
import dtos_infraestructura.SolicitudTerminalDTO;
import excepciones.InfraestructuraTerminalException;
import interfaces.ISistemaTerminal;
import terminal.SistemaTerminal;

/**
 *
 * @author valeria
 */
public class TerminalFachada implements ISistemaTerminal {
    private final SistemaTerminal sistema;

    public TerminalFachada() {
        this.sistema = new SistemaTerminal();
    }

    @Override
    public RespuestaTerminalDTO cobrarTarjeta(SolicitudTerminalDTO solicitud) throws InfraestructuraTerminalException{
        return sistema.cobrarTarjeta(solicitud);
    }
}
