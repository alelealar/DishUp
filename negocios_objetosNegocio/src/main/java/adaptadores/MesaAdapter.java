/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package adaptadores;

import dto.MesaDTO;
import entidadesMongo.Mesa;
import enums.EstadoMesa;
import enums.EstadoMesaDTO;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author DishUp
 */

public class MesaAdapter {

    public MesaAdapter() {
    }
            
    public static MesaDTO toDTO(Mesa mesa){
        if(mesa == null){
            return null;
        }
        
        return new MesaDTO(
                mesa.getId(), 
                mesa.getNumero(), 
                EstadoMesaDTO.valueOf(mesa.getEstado().name()), 
                mesa.getIdMesero());
    }
    
    public static Mesa toEntity(MesaDTO dto){
        if(dto == null){
            return null;
        }
        
        Mesa mesa = new Mesa();
        mesa.setId(dto.getIdMesa());
        mesa.setNumero(dto.getNumeroMesa());
        mesa.setEstado(EstadoMesa.valueOf(dto.getEstado().name()));
        mesa.setIdMesero(dto.getIdMesero());
        
        return mesa;
    }
    
    public static List<MesaDTO> listEntityToDTO(List<Mesa> mesas){
        List<MesaDTO> listaDTO = new ArrayList<>();
        for(Mesa m: mesas){
            listaDTO.add(toDTO(m));
        }
        
        return listaDTO;
    }
}
