/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package interfaz;

import dtos.MesaDTO;
import excepciones.MesasException;
import java.util.List;

/**
 *
 * @author DishUp
 */
public interface IGestionMesas {
    List<MesaDTO> obtenerMesasPorMesero(String idMesero) throws MesasException;
}
