/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package interfaces;

import entidadesMongo.Ingrediente;
import java.util.List;

/**
 *
 * @author DishUp
 */
public interface IIngredienteDAO {
    
    public Ingrediente buscarPorId(String id);
    
    public List<Ingrediente> obtenerIngredientes();
}
