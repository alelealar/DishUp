/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BO;

import Interface.IMesaBO;
import dto.MesaDTO;
import enums.EstadoMesa;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author DishUp
 */

public class MesaBO implements IMesaBO {
    
    private static MesaBO instancia;
    
    private MesaBO(){
       
    }
    
    public static MesaBO getInstancia(){
        if (instancia == null) {
            instancia = new MesaBO();
        }
        return instancia;
    }
    
    @Override
    public List<MesaDTO> obtenerMesasPorMesero(int idMesero) {

        List<MesaDTO> mesas = new ArrayList<>();

        mesas.add(new MesaDTO(1, 1, EstadoMesa.LIBRE, 1));
        mesas.add(new MesaDTO(2, 2, EstadoMesa.LIBRE, 1));
        mesas.add(new MesaDTO(3, 4, EstadoMesa.LIBRE, 1));
        mesas.add(new MesaDTO(4, 6, EstadoMesa.LIBRE, 1));
        mesas.add(new MesaDTO(5, 7, EstadoMesa.LIBRE, 1));
        mesas.add(new MesaDTO(6, 9, EstadoMesa.LIBRE, 1));

        return mesas;
    }
    
}
