/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package objetosNegocio;

import Interface.IMesaBO;
import adaptadores.MesaAdapter;
import daos.MesaDAO;
import dto.MesaDTO;
import entidadesMongo.Mesa;
import enums.EstadoMesaDTO;
import excepciones.NegocioException;
import interfaces.IMesaDAO;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author DishUp
 */

public class MesaBO implements IMesaBO {
    
    private IMesaDAO mesaDAO;

    public MesaBO() {
        this.mesaDAO = new MesaDAO();
    }
    
    @Override
    public List<MesaDTO> obtenerMesasPorMesero(String idMesero) throws NegocioException {
        if(idMesero == null || idMesero.isBlank()){
            throw new NegocioException("El id es invalido");
        }
        List<Mesa> mesas = mesaDAO.obtenerMesasPorMesero(idMesero);
        
        return MesaAdapter.listEntityToDTO(mesas);
    }
    
}


/*
        mesas.add(new MesaDTO(1, 1, EstadoMesaDTO.LIBRE, 1));
        mesas.add(new MesaDTO(2, 2, EstadoMesaDTO.LIBRE, 1));
        mesas.add(new MesaDTO(3, 4, EstadoMesaDTO.LIBRE, 1));
        mesas.add(new MesaDTO(4, 6, EstadoMesaDTO.LIBRE, 1));
        mesas.add(new MesaDTO(5, 7, EstadoMesaDTO.LIBRE, 1));
        mesas.add(new MesaDTO(6, 9, EstadoMesaDTO.LIBRE, 1));
*/