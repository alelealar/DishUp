/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BO;

import Interface.IProductoBO;
import dto.IngredienteDTO;
import dto.ProductoDTO;
import dto.ProductoIngredienteDTO;
import enums.TipoProducto;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author DishUp
 */

public class ProductoBO implements IProductoBO{
    private static ProductoBO instancia;
    
    private ProductoBO(){
       
    }
    
    public static ProductoBO getInstancia(){
        if (instancia == null) {
            instancia = new ProductoBO();
        }
        return instancia;
    }
    
    /**
     * Obtiene los productos de un tipo específico.
     *
     * @param tipo Tipo de producto a filtrar.
     * @return Lista de productos que coinciden con el tipo.
     */
    @Override
    public List<ProductoDTO> obtenerProductosPorTipo(TipoProducto tipo){
        List<ProductoDTO> productos = new ArrayList<>();
        
        productos.add(new ProductoDTO(1, "Bloody Mary", 120.0, true, 600, TipoProducto.BEBIDA, "/img/producto_Bebida_blodyMary.png"));
        productos.add(new ProductoDTO(2, "Cóctel Rosa", 110.0, true, 450, TipoProducto.BEBIDA, "/img/producto_Bebida_coctelRosa.png"));
        productos.add(new ProductoDTO(3, "Cuba Libre", 100.0, true, 300, TipoProducto.BEBIDA, "/img/producto_Bebida_cuba.png"));
        productos.add(new ProductoDTO(4, "Margarita Fresa", 130.0, true, 500, TipoProducto.BEBIDA, "/img/producto_Bebida_margaritaFresa.png"));
        productos.add(new ProductoDTO(5, "Margarita Limón", 125.0, true, 480, TipoProducto.BEBIDA, "/img/producto_Bebida_MargaritaLimon.png"));
        productos.add(new ProductoDTO(6, "Martini", 140.0, true, 300, TipoProducto.BEBIDA, "/img/producto_Bebida_martini.png"));
        productos.add(new ProductoDTO(7, "Martini Café", 145.0, false, 350, TipoProducto.BEBIDA, "/img/producto_Bebida_martiniCafe.png"));
        productos.add(new ProductoDTO(8, "Mojito", 115.0, true, 420, TipoProducto.BEBIDA, "/img/producto_Bebida_mojito.png"));
        productos.add(new ProductoDTO(9, "Piña Colada", 135.0, true, 550, TipoProducto.BEBIDA, "/img/producto_Bebida_piñaColada.png"));
        productos.add(new ProductoDTO(10, "Sex On The Beach", 150.0, true, 500, TipoProducto.BEBIDA, "/img/producto_Bebida_sexOnTheBeach.png"));
        productos.add(new ProductoDTO(11, "Whiskey", 160.0, true, 200, TipoProducto.BEBIDA, "/img/producto_Bebida_whiskey.png"));
        
        
        List<ProductoDTO> filtrados = new ArrayList<>();
        for (ProductoDTO p : productos) {
            if (p.getTipo() == tipo) {
                filtrados.add(p);
            }
        }
        return filtrados;
    }
    
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
    
    public List<ProductoIngredienteDTO> obtenerProductoIngredientes() {
        List<ProductoIngredienteDTO> relaciones = new ArrayList<>();

        // 1 - Bloody Mary
        relaciones.add(new ProductoIngredienteDTO(1, 1, 1, 1, false)); // Jugo de tomate
        relaciones.add(new ProductoIngredienteDTO(2, 1, 2, 1, false)); // Vodka
        relaciones.add(new ProductoIngredienteDTO(3, 1, 3, 1, true));  // Hielo
        relaciones.add(new ProductoIngredienteDTO(4, 1, 4, 1, true));  // Apio

        // 2 - Cóctel Rosa
        relaciones.add(new ProductoIngredienteDTO(5, 2, 7, 1, false)); // Fresa
        relaciones.add(new ProductoIngredienteDTO(6, 2, 6, 1, true));  // Crema batida
        relaciones.add(new ProductoIngredienteDTO(7, 2, 3, 1, true));  // Hielo

        // 3 - Cuba Libre
        relaciones.add(new ProductoIngredienteDTO(8, 3, 9, 1, false));  // Ron
        relaciones.add(new ProductoIngredienteDTO(9, 3, 10, 1, false)); // Refresco de cola
        relaciones.add(new ProductoIngredienteDTO(10, 3, 8, 1, true));  // Limón
        relaciones.add(new ProductoIngredienteDTO(11, 3, 3, 1, true));  // Hielo

        // 4 - Margarita Fresa
        relaciones.add(new ProductoIngredienteDTO(12, 4, 7, 1, false)); // Fresa
        relaciones.add(new ProductoIngredienteDTO(13, 4, 8, 1, false)); // Limón
        relaciones.add(new ProductoIngredienteDTO(14, 4, 3, 1, true));  // Hielo

        // 5 - Margarita Limón
        relaciones.add(new ProductoIngredienteDTO(15, 5, 8, 1, false)); // Limón
        relaciones.add(new ProductoIngredienteDTO(16, 5, 3, 1, true));  // Hielo

        // 6 - Martini
        relaciones.add(new ProductoIngredienteDTO(17, 6, 2, 1, false)); // Vodka
        relaciones.add(new ProductoIngredienteDTO(18, 6, 5, 1, true));  // Cereza

        // 7 - Martini Café
        relaciones.add(new ProductoIngredienteDTO(19, 7, 11, 1, false)); // Café
        relaciones.add(new ProductoIngredienteDTO(20, 7, 2, 1, false));  // Vodka
        relaciones.add(new ProductoIngredienteDTO(21, 7, 6, 1, true));   // Crema batida

        // 8 - Mojito
        relaciones.add(new ProductoIngredienteDTO(22, 8, 9, 1, false));  // Ron
        relaciones.add(new ProductoIngredienteDTO(23, 8, 12, 1, false)); // Hierbabuena
        relaciones.add(new ProductoIngredienteDTO(24, 8, 8, 1, true));   // Limón
        relaciones.add(new ProductoIngredienteDTO(25, 8, 3, 1, true));   // Hielo

        // 9 - Piña Colada
        relaciones.add(new ProductoIngredienteDTO(26, 9, 13, 1, false)); // Piña
        relaciones.add(new ProductoIngredienteDTO(27, 9, 14, 1, false)); // Crema de coco
        relaciones.add(new ProductoIngredienteDTO(28, 9, 3, 1, true));   // Hielo
        relaciones.add(new ProductoIngredienteDTO(29, 9, 5, 1, true));   // Cereza
        relaciones.add(new ProductoIngredienteDTO(30, 9, 6, 1, true));   // Crema batida

        // 10 - Sex On The Beach
        relaciones.add(new ProductoIngredienteDTO(31, 10, 15, 1, false)); // Jugo de naranja
        relaciones.add(new ProductoIngredienteDTO(32, 10, 2, 1, false));  // Vodka
        relaciones.add(new ProductoIngredienteDTO(33, 10, 3, 1, true));   // Hielo
        relaciones.add(new ProductoIngredienteDTO(34, 10, 5, 1, true));   // Cereza

        // 11 - Whiskey
        relaciones.add(new ProductoIngredienteDTO(35, 11, 16, 1, false)); // Whiskey
        relaciones.add(new ProductoIngredienteDTO(36, 11, 3, 1, true));   // Hielo

        return relaciones;
    }
    
    /**
     *
     * @param idProducto
     * @return
     */
    @Override
    public List<IngredienteDTO> obtenerIngredientesRemoviblesPorProducto(int idProducto) {
        List<IngredienteDTO> removibles = new ArrayList<>();

        List<ProductoIngredienteDTO> relaciones = obtenerProductoIngredientes();
        List<IngredienteDTO> ingredientes = obtenerIngredientes();

        for (ProductoIngredienteDTO relacion : relaciones) {
            if (relacion.getIdProducto() == idProducto && relacion.isRemovible()) {
                for (IngredienteDTO ingrediente : ingredientes) {
                    if (ingrediente.getId() == relacion.getIdIngrediente()) {
                        removibles.add(ingrediente);
                        break;
                    }
                }
            }
        }

        return removibles;
    }
    
    public List<String> obtenerModificadoresRemoviblesPorProducto(int idProducto) {
        List<String> modificadores = new ArrayList<>();

        List<IngredienteDTO> ingredientes = obtenerIngredientesRemoviblesPorProducto(idProducto);

        for (IngredienteDTO ingrediente : ingredientes) {
            modificadores.add("Sin " + ingrediente.getNombre().toLowerCase());
        }

        return modificadores;
    }
}
