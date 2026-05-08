/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricas;

import BO.ComandaBO;
import control.ComandaControl;
import control.ProductoControl;
import daos.ComandaDAO;
import fachada.ComandaFachada;
import interfaces.IComandaDAO;
import objetosNegocio.ComandaBO;

/**
 *
 * @author DishUp
 */
public class FabricaComandas {

    public static ComandaControl crear(ProductoControl productoControl) {

        IComandaDAO comandaDAO = new ComandaDAO();

        ComandaBO bo = new ComandaBO(
                productoControl.getProductoFachada(),
                comandaDAO
        );

        ComandaFachada fachada = new ComandaFachada(bo);

        return new ComandaControl(fachada);
    }
}
