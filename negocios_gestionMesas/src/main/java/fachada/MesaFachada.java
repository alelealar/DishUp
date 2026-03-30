/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package fachada;

import BO.MesaBO;
import Interface.IMesaBO;
import dto.MesaDTO;
import java.util.List;


/**
 *
 * @author DishUp
 */

public class MesaFachada {
    private IMesaBO mesaBO;

    public MesaFachada() {
        this.mesaBO = MesaBO.getInstancia();
    }
    
    public List<MesaDTO> obtenerMesasPorMesero(int idMesero) {
        return mesaBO.obtenerMesasPorMesero(idMesero);
    }
}
