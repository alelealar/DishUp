package control;

import fachada.IngredienteFachada;
import dto.IngredienteDTO;
import java.util.List;

/**
 * 
 * @author DishUp
 */
public class IngredienteControl {

    private final IngredienteFachada fachada;

    public IngredienteControl(IngredienteFachada fachada) {
        this.fachada = fachada;
    }
    
    public List<IngredienteDTO> obtenerIngredientes() {
        return fachada.obtenerIngredientes();
    }
}