/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import BO.IngredienteBO;
import Interface.IIngredienteBO;
import dto.IngredienteDTO;
import java.util.List;

/**
 *
 * @author DishUp
 */
public class IngredienteFachada implements IIngredienteBO{
    
    private static IngredienteFachada instancia;
    private IIngredienteBO ingredienteBO;

    private IngredienteFachada() {
        this.ingredienteBO = IngredienteBO.getInstancia();
    }
    
    public static IngredienteFachada getInstancia(){
        if (instancia == null) {
            instancia = new IngredienteFachada();
        }
        return instancia;
    }
    
    @Override
    public List<IngredienteDTO> obtenerIngredientes(){
        return ingredienteBO.obtenerIngredientes();
    }
}
