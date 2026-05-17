/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

import adaptadores.PagoNegocioAdapter;
import daos.ComandaDAO;
import dtos.ResultadoPagoDTO;
import dtos.SolicitudPagoDTO;
import entidades.Comanda;
import entidades.Pago;
import enums.EstadoComanda;
import excepcion.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IComandaDAO;
import java.util.List;
import procesadores.IProcesadorPago;
import procesadores.ProcesadorPagoFactory;


/**
 *
 * @author valeria
 */
public class PagoBO {
    
    private final IComandaDAO comandaDAO;
    private final PagoNegocioAdapter adapter;

    public PagoBO() {
        this.comandaDAO = new ComandaDAO();
        this.adapter = new PagoNegocioAdapter();
    }


    public boolean puedePagarMesa(int numeroMesa) throws NegocioException {
        if (numeroMesa <= 0) {
            throw new NegocioException("El número de mesa es inválido.");
        }

        try {
            List<Comanda> comandas = comandaDAO.obtenerComandasPorMesa(numeroMesa);

            if (comandas == null || comandas.isEmpty()) {
                return false;
            }

            boolean comandasPendientesPago = false;
            
            for (Comanda comanda : comandas) {
                EstadoComanda estado = comanda.getEstado();
                
                // Si hay alguna comanda que no esté ni LISTA ni PAGADA (ej. EN_PREPARACION), no se puede pagar la mesa
                if (estado != EstadoComanda.LISTA && estado != EstadoComanda.PAGADA) {
                    return false;
                }
                
                if (estado == EstadoComanda.LISTA) {
                    comandasPendientesPago = true;
                }
            }

            return comandasPendientesPago;

        } catch (PersistenciaException ex) {
            throw new NegocioException(
                    "No fue posible validar si la mesa puede pagarse.",
                    ex
            );
        }
    }

    public boolean puedePagarComanda(String idComanda) throws NegocioException {
        if (idComanda == null || idComanda.isBlank()) {
            throw new NegocioException("El id de la comanda es inválido.");
        }

        try {
            Comanda comanda = comandaDAO.obtenerPorId(idComanda);

            if (comanda == null) {
                throw new NegocioException("La comanda no existe.");
            }

            return comanda.getEstado() == EstadoComanda.LISTA;

        } catch (PersistenciaException ex) {
            throw new NegocioException(
                    "No fue posible validar si la comanda puede pagarse.",
                    ex
            );
        }
    }
    
    public ResultadoPagoDTO registrarPago(SolicitudPagoDTO solicitud) throws NegocioException {
        if (solicitud == null) {
            throw new NegocioException("Solicitud vacia");
        }

        if (solicitud.getIdComanda() == null || solicitud.getIdComanda().isBlank()) {
            throw new NegocioException("Id de comanda inválido");
        }

        IProcesadorPago procesador = ProcesadorPagoFactory.crearProcesador(solicitud.getMetodoPago());

        ResultadoPagoDTO resultado = procesador.procesarPago(solicitud);
        
        if (!resultado.isAprobado()) {
            throw new NegocioException(resultado.getMensaje());
        }
        
        Pago pago = adapter.aEntidad(resultado);
        
        try {
            boolean guardado = comandaDAO.insertarPagoAComanda(solicitud.getIdComanda(), pago);

            if (!guardado) {
                throw new NegocioException("No se pudo guardar el pago en la comanda.");
            }

        } catch (PersistenciaException e) {
            throw new NegocioException("Error al guardar el pago", e);
        }
        return resultado;
    }

    
    
}
