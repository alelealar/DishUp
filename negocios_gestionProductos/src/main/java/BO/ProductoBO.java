/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package BO;

import Interface.IProductoBO;
import dto.ProductoDTO;
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
}
