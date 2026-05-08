package fachada;

import objetosNegocio.IngredienteBO;
import Interface.IIngredienteBO;
import dto.IngredienteDTO;
import java.util.List;

/**
 * 
 * @author DishUp
 */
public class IngredienteFachada {

    private final IIngredienteBO ingredienteBO;

    public IngredienteFachada(IIngredienteBO ingredienteBO) {
        this.ingredienteBO = ingredienteBO;
    }

    public List<IngredienteDTO> obtenerIngredientes() {
        return ingredienteBO.obtenerIngredientes();
    }
}