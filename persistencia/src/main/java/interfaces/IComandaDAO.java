/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Comanda;
import entidades.Pedido;
import excepciones.PersistenciaException;

/**
 *
 * @author valeria
 */
public interface IComandaDAO {
    boolean agregarPedido(String idComanda, Pedido nuevoPedido) throws PersistenciaException;
    Comanda insertarComanda(Comanda comanda) throws PersistenciaException;
}
