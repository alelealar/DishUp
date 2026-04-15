package fachada;

import BO.IngredienteBO;
import Interface.IIngredienteBO;
import dto.IngredienteDTO;
import java.util.List;

/**
 * 
 * @author DishUp
 */
public class IngredienteFachada {

    private IIngredienteBO ingredienteBO;

    public IngredienteFachada() {
        this.ingredienteBO = IngredienteBO.getInstancia();
    }

    public List<IngredienteDTO> obtenerIngredientes() {
        return ingredienteBO.obtenerIngredientes();
    }
}