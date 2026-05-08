/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosNegocio;

import Interface.IIngredienteBO;
import dto.IngredienteDTO;
import dto.ProductoIngredienteDTO;
import entidadesMongo.Ingrediente;
import interfaces.IIngredienteDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DishUp
 */
public class IngredienteBO implements IIngredienteBO{
    private final IIngredienteDAO ingredienteDAO;

    public IngredienteBO(IIngredienteDAO ingredienteDAO) {
        this.ingredienteDAO = ingredienteDAO;
    }

    @Override
    public List<IngredienteDTO> obtenerIngredientes() {

        List<Ingrediente> ingredientes = ingredienteDAO.obtenerIngredientes();

        List<IngredienteDTO> dtos = new ArrayList<>();

        for (Ingrediente i : ingredientes) {

            IngredienteDTO dto = new IngredienteDTO();
            dto.setId(i.getId());
            dto.setNombre(i.getNombre());
            dto.setStockActual(i.getStockActual());
            dto.setStockMinimo(i.getStockMinimo());

            dtos.add(dto);
        }

        return dtos;
    }
}
    /*
    List<IngredienteDTO> ingredientes = new ArrayList<>();
        
        //bebidas
        ingredientes.add(new IngredienteDTO(1, "Jugo de tomate", 30, 5));
        ingredientes.add(new IngredienteDTO(2, "Vodka", 20, 5));
        ingredientes.add(new IngredienteDTO(3, "Hielo", 100, 20));
        ingredientes.add(new IngredienteDTO(4, "Apio", 15, 3));
        ingredientes.add(new IngredienteDTO(5, "Cereza", 25, 5));
        ingredientes.add(new IngredienteDTO(6, "Crema batida", 15, 3));
        ingredientes.add(new IngredienteDTO(7, "Fresa", 20, 5));
        ingredientes.add(new IngredienteDTO(8, "Limón", 30, 5));
        ingredientes.add(new IngredienteDTO(9, "Ron", 25, 5));
        ingredientes.add(new IngredienteDTO(10, "Refresco de cola", 40, 10));
        ingredientes.add(new IngredienteDTO(11, "Café", 20, 5));
        ingredientes.add(new IngredienteDTO(12, "Hierbabuena", 18, 4));
        ingredientes.add(new IngredienteDTO(13, "Piña", 20, 5));
        ingredientes.add(new IngredienteDTO(14, "Crema de coco", 15, 5));
        ingredientes.add(new IngredienteDTO(15, "Jugo de naranja", 25, 5));
        ingredientes.add(new IngredienteDTO(16, "Whiskey", 20, 5));
        
        //botanas
        ingredientes.add(new IngredienteDTO(17, "Papas", 100, 20));
        ingredientes.add(new IngredienteDTO(18, "Queso", 80, 15));
        ingredientes.add(new IngredienteDTO(19, "Pollo", 90, 20));
        ingredientes.add(new IngredienteDTO(20, "Aceite", 100, 30));
        ingredientes.add(new IngredienteDTO(21, "Sal", 200, 50));
        ingredientes.add(new IngredienteDTO(22, "Sazonador", 100, 20));
        ingredientes.add(new IngredienteDTO(23, "Maíz palomero", 80, 15));
        ingredientes.add(new IngredienteDTO(24, "Mantequilla", 70, 10));
        ingredientes.add(new IngredienteDTO(25, "Totopos", 100, 20));
        ingredientes.add(new IngredienteDTO(26, "Frijoles", 60, 10));
        ingredientes.add(new IngredienteDTO(27, "Salsa", 90, 15));
        ingredientes.add(new IngredienteDTO(28, "Aceitunas", 50, 10));
        ingredientes.add(new IngredienteDTO(29, "pollo empanizado", 80, 15));
        ingredientes.add(new IngredienteDTO(30, "Aros de cebolla", 70, 10));
        ingredientes.add(new IngredienteDTO(31, "Ketchup", 80, 15));
        
        
        //comida
        ingredientes.add(new IngredienteDTO(32, "Tortilla", 100, 20));
        ingredientes.add(new IngredienteDTO(33, "Carne", 90, 20));
        ingredientes.add(new IngredienteDTO(34, "Pan", 80, 15));
        ingredientes.add(new IngredienteDTO(35, "Lechuga", 70, 10));
        ingredientes.add(new IngredienteDTO(36, "Tomate", 70, 10));
        ingredientes.add(new IngredienteDTO(37, "Pepperoni", 60, 10));
        ingredientes.add(new IngredienteDTO(38, "Aderezo César", 50, 10));

        return ingredientes;
    */
    
