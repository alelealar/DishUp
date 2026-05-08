/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package interfaces;

import entidadesMongo.Producto;
import enums.TipoProducto;
import java.util.List;

/**
 *
 * @author DishUp
 */
public interface IProductoDAO {
     
    public List<Producto> buscar(String nombre, TipoProducto tipo, Boolean disponible);
    
    public List<Producto> obtenerProductosPorTipo(TipoProducto tipo);
    
    public Producto obtenerProductoPorId(String id);
}
