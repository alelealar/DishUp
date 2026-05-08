/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package interfaces;

import entidadesMongo.Mesa;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author DishUp
 */
public interface IMesaDAO {

    public List<Mesa> obtenerMesasPorMesero(String idMesero);
    
    public Mesa insertarMesa(Mesa mesa) throws PersistenciaException;
}
