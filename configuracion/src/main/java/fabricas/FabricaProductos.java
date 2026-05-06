/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricas;

import BO.ProductoBO;
import control.ProductoControl;
import daos.IngredienteDAO;
import daos.ProductoDAO;
import fachada.ProductoFachada;
import infraestructura.InventarioAPI;
import interfaces.IIngredienteDAO;
import interfaces.IProductoDAO;

/**
 *
 * @author DishUp
 */
public class FabricaProductos {

    public static ProductoControl crear() {
        InventarioAPI inventarioAPI = new InventarioAPI();

        ProductoBO bo = new ProductoBO(inventarioAPI);

        ProductoFachada fachada = new ProductoFachada(bo);

        return new ProductoControl(fachada);
    }
}
