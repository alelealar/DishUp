package control;

import fachada.IngredienteFachada;
import dto.IngredienteDTO;
import java.util.List;

/**
 * 
 * @author DishUp
 */
public class IngredienteControl {

    private IngredienteFachada fachada;

    public IngredienteControl() {
        this.fachada = new IngredienteFachada();
    }

    public List<IngredienteDTO> obtenerIngredientes() {
        return fachada.obtenerIngredientes();
    }
}