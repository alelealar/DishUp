/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package Interface;

import dto.MesaDTO;
import excepcion.NegocioException;
import java.util.List;

/**
 *
 * @author DishUp
 */
public interface IMesaBO {
    
    public List<MesaDTO> obtenerMesasPorMesero(String idMesero) throws NegocioException;
}
