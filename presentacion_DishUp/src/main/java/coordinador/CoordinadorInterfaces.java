/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package coordinador;

import dto.IngredienteDTO;
import dto.MesaDTO;
import dto.PedidoNuevoDTO;
import dto.ProductoDTO;
import java.util.ArrayList;
import java.util.List;
import pantallas.DlgModificarProducto;
import pantallas.DlgResumenComanda;
import pantallas.FrmCliente;
import pantallas.FrmPantallaComandas;
import pantallas.FrmProductos;


/**
 *
 * @author DishUp
 */

public class CoordinadorInterfaces {
    private FrmPantallaComandas frmComandas;
    private FrmCliente frmCliente;
    private FrmProductos frmProductos;
    
    private List<PedidoNuevoDTO> comandaTemporal = new ArrayList<>();
    
    
    
    public void mostrarRegistrarCliente(MesaDTO mesa){
        frmCliente = new FrmCliente();
        frmCliente.setNumeroMesa(mesa.getNumeroMesa());
        frmCliente.setVisible(true);
    }
    
    public void regresarFrmComandas(){
        frmComandas = new FrmPantallaComandas(this);
        frmComandas.setVisible(true);
    }
    
    
    public void frmClienteAFrmProductos(Integer mesa, String nombreCliente){
        frmProductos = new FrmProductos(this);
        frmProductos.setMesaAndCliente(mesa, nombreCliente);
        frmProductos.setVisible(true);
    }
    
    
    public void frmProductosAFrmCliente(String nombreCliente, Integer numMesa){
        frmCliente = new FrmCliente();
        frmCliente.setNombreCliente(nombreCliente);
        frmCliente.setNumeroMesa(numMesa);
        frmCliente.setVisible(true);
    }
    
    public void abrirPersonalizacionProducto(FrmProductos frm, ProductoDTO producto, List<IngredienteDTO> removibles) {
    
        DlgModificarProducto dlg = new DlgModificarProducto(frm, producto, removibles);
        dlg.setVisible(true);

        PedidoNuevoDTO pedido = dlg.getResultado();

        if (pedido != null) {
            comandaTemporal.add(pedido);
            frm.agregarPedidoVisual(pedido);
        }
    }
    
    public void abrirResumenComanda (FrmProductos frm, int mesa, String nombreCliente){
        DlgResumenComanda dlg = new DlgResumenComanda(frm, comandaTemporal);
        dlg.setMesaAndCliente(mesa, nombreCliente);
        dlg.setVisible(true);
        
    }
    

}