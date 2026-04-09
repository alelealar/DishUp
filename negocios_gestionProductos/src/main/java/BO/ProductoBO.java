/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BO;

import Interface.IIngredienteBO;
import Interface.IProductoBO;
import dto.IngredienteDTO;
import dto.ProductoDTO;
import dto.ProductoIngredienteDTO;
import enums.TipoProducto;
import fachada.IngredienteFachada;
import java.awt.color.ICC_ColorSpace;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author DishUp
 */

public class ProductoBO implements IProductoBO{
    
    private static ProductoBO instancia;
    
    private final IIngredienteBO inventario = IngredienteFachada.getInstancia();

    private ProductoBO() { }

    public static ProductoBO getInstancia() {
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
        
        //bebidas
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

        //botanas
        productos.add(new ProductoDTO(12, "Aros de cebolla", 80.0, true, 900, TipoProducto.BOTANA, "/img/producto_Botana_arosDeCebolla.jpg"));
        productos.add(new ProductoDTO(13, "Boneless", 120.0, true, 1200, TipoProducto.BOTANA, "/img/producto_Botana_boneless.png"));
        productos.add(new ProductoDTO(14, "Cacahuates", 50.0, true, 300, TipoProducto.BOTANA, "/img/producto_Botana_cacahuates.png"));
        productos.add(new ProductoDTO(15, "Dedos de queso", 90.0, true, 900, TipoProducto.BOTANA, "/img/producto_Botana_dedosDeQueso.png"));
        productos.add(new ProductoDTO(16, "Nachos", 100.0, true, 900, TipoProducto.BOTANA, "/img/producto_Botana_nachos.png"));
        productos.add(new ProductoDTO(17, "Palomitas", 60.0, true, 600, TipoProducto.BOTANA, "/img/producto_Botana_palomitas.png"));
        productos.add(new ProductoDTO(18, "Papas sazonadas", 85.0, true, 900, TipoProducto.BOTANA, "/img/producto_Botana_papasSazonadas.png"));
        productos.add(new ProductoDTO(19, "Papas francesas", 80.0, true, 900, TipoProducto.BOTANA, "/img/producto_Botana_papasFrancesas.png"));
        productos.add(new ProductoDTO(20, "Papas", 70.0, true, 800, TipoProducto.BOTANA, "/img/producto_Botana_papas.png"));
        productos.add(new ProductoDTO(21, "Aceitunas", 65.0, true, 300, TipoProducto.BOTANA, "/img/producto_Botana_aceitunas.png"));
        productos.add(new ProductoDTO(22, "Nuggets", 95.0, true, 900, TipoProducto.BOTANA, "/img/producto_Botana_nuggets.png"));
        
        //comidas
        productos.add(new ProductoDTO(23, "Quesadilla", 90.0, true, 800, TipoProducto.COMIDA, "/img/producto_Comida_quesadilla.png"));
        productos.add(new ProductoDTO(24, "Hamburguesa de carne", 130.0, true, 1200, TipoProducto.COMIDA, "/img/producto_Comida_hamburguesa.png"));
        productos.add(new ProductoDTO(25, "Pizza de Pepperoni", 150.0, true, 1500, TipoProducto.COMIDA, "/img/producto_Comida_pizza.png"));
        productos.add(new ProductoDTO(26, "Tacos", 100.0, true, 900, TipoProducto.COMIDA, "/img/producto_Comida_tacos.png"));
        productos.add(new ProductoDTO(27, "Ensalada César", 110.0, true, 700, TipoProducto.COMIDA, "/img/producto_Comida_ensaladaCesar.png"));
        productos.add(new ProductoDTO(28, "Filete de carne", 180.0, true, 1600, TipoProducto.COMIDA, "/img/producto_Comida_fileteDeCarne.png"));
        
        List<ProductoDTO> filtrados = new ArrayList<>();
        for (ProductoDTO p : productos) {
            if (p.getTipo() == tipo) {
                filtrados.add(p);
            }
        }
        return filtrados;
    }
    
    @Override
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
        
        // 12 - Aros de cebolla
        relaciones.add(new ProductoIngredienteDTO(37, 12, 30, 1, false)); // Aros de cebolla
        relaciones.add(new ProductoIngredienteDTO(38, 12, 20, 1, false)); // Aceite
        relaciones.add(new ProductoIngredienteDTO(39, 12, 21, 1, true));  // Sal

        // 13 - Boneless
        relaciones.add(new ProductoIngredienteDTO(40, 13, 19, 1, false)); // Pollo
        relaciones.add(new ProductoIngredienteDTO(41, 13, 27, 1, true));  // Salsa

        // 14 - Cacahuates
        relaciones.add(new ProductoIngredienteDTO(42, 14, 21, 1, true)); // Sal

        // 15 - Dedos de queso
        relaciones.add(new ProductoIngredienteDTO(43, 15, 18, 1, false)); // Queso
        relaciones.add(new ProductoIngredienteDTO(44, 15, 20, 1, false)); // Aceite

        // 16 - Nachos
        relaciones.add(new ProductoIngredienteDTO(45, 16, 25, 1, false)); // Totopos
        relaciones.add(new ProductoIngredienteDTO(46, 16, 18, 1, false)); // Queso
        relaciones.add(new ProductoIngredienteDTO(47, 16, 26, 1, true));  // Frijoles
        relaciones.add(new ProductoIngredienteDTO(48, 16, 27, 1, true));  // Salsa

        // 17 - Palomitas
        relaciones.add(new ProductoIngredienteDTO(49, 17, 23, 1, false)); // Maíz palomero
        relaciones.add(new ProductoIngredienteDTO(50, 17, 24, 1, true));  // Mantequilla
        relaciones.add(new ProductoIngredienteDTO(51, 17, 21, 1, true));  // Sal

        // 18 - Papas sazonadas
        relaciones.add(new ProductoIngredienteDTO(52, 18, 17, 1, false)); // Papas
        relaciones.add(new ProductoIngredienteDTO(53, 18, 22, 1, true));  // Sazonador

        // 19 - Papas francesas
        relaciones.add(new ProductoIngredienteDTO(54, 19, 17, 1, false)); // Papas
        relaciones.add(new ProductoIngredienteDTO(55, 19, 21, 1, true));  // Sal

        // 20 - Papas
        relaciones.add(new ProductoIngredienteDTO(56, 20, 17, 1, false)); // Papas

        // 21 - Aceitunas
        relaciones.add(new ProductoIngredienteDTO(57, 21, 28, 1, false)); // Aceitunas

        // 22 - Nuggets
        relaciones.add(new ProductoIngredienteDTO(58, 22, 29, 1, false)); // Pollo empanizado
        relaciones.add(new ProductoIngredienteDTO(59, 22, 31, 1, true));  // ketchup
        
        // 23 - Quesadilla
        relaciones.add(new ProductoIngredienteDTO(60, 23, 32, 1, false)); // Tortilla
        relaciones.add(new ProductoIngredienteDTO(61, 23, 18, 1, false)); // Queso

        // 24 - Hamburguesa
        relaciones.add(new ProductoIngredienteDTO(62, 24, 34, 1, false)); // Pan
        relaciones.add(new ProductoIngredienteDTO(63, 24, 33, 1, false)); // Carne
        relaciones.add(new ProductoIngredienteDTO(64, 24, 18, 1, true));  // Queso
        relaciones.add(new ProductoIngredienteDTO(65, 24, 35, 1, true));  // Lechuga
        relaciones.add(new ProductoIngredienteDTO(66, 24, 36, 1, true));  // Tomate
        relaciones.add(new ProductoIngredienteDTO(67, 24, 31, 1, true));  // Ketchup

        // 25 - Pizza
        relaciones.add(new ProductoIngredienteDTO(68, 25, 18, 1, false)); // Queso
        relaciones.add(new ProductoIngredienteDTO(69, 25, 37, 1, true));  // Pepperoni
        relaciones.add(new ProductoIngredienteDTO(70, 25, 27, 1, false)); // Salsa

        // 26 - Tacos
        relaciones.add(new ProductoIngredienteDTO(71, 26, 32, 1, false)); // Tortilla
        relaciones.add(new ProductoIngredienteDTO(72, 26, 33, 1, false)); // Carne
        relaciones.add(new ProductoIngredienteDTO(73, 26, 27, 1, true));  // Salsa
        relaciones.add(new ProductoIngredienteDTO(74, 26, 21, 1, true));  // Sal

        // 27 - Ensalada César
        relaciones.add(new ProductoIngredienteDTO(75, 27, 35, 1, false)); // Lechuga
        relaciones.add(new ProductoIngredienteDTO(76, 27, 19, 1, true));  // Pollo
        relaciones.add(new ProductoIngredienteDTO(77, 27, 38, 1, false)); // Aderezo César

        // 28 - Filete de carne
        relaciones.add(new ProductoIngredienteDTO(78, 28, 33, 1, false)); // Carne
        relaciones.add(new ProductoIngredienteDTO(79, 28, 21, 1, true));  // Sal
        relaciones.add(new ProductoIngredienteDTO(80, 28, 20, 1, false)); // Aceite

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
        List<IngredienteDTO> ingredientes = inventario.obtenerIngredientes();

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
    
    @Override
    public List<String> obtenerModificadoresRemoviblesPorProducto(int idProducto) {
        List<String> modificadores = new ArrayList<>();

        List<IngredienteDTO> ingredientes = obtenerIngredientesRemoviblesPorProducto(idProducto);

        for (IngredienteDTO ingrediente : ingredientes) {
            modificadores.add("Sin " + ingrediente.getNombre().toLowerCase());
        }

        return modificadores;
    }
}
