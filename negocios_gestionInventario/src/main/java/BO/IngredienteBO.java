/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Interface.IIngredienteBO;
import dto.IngredienteDTO;
import dto.ProductoIngredienteDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DishUp
 */
public class IngredienteBO implements IIngredienteBO{
    
    private static IngredienteBO instancia;
    

    public IngredienteBO() {
    }
    
    public static IngredienteBO getInstancia(){
        if (instancia == null) {
            instancia = new IngredienteBO();
        }
        return instancia;
    }
    
    @Override                                                               
    public List<IngredienteDTO> obtenerIngredientes() {
        List<IngredienteDTO> ingredientes = new ArrayList<>();

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

        return ingredientes;
    }
    
}
