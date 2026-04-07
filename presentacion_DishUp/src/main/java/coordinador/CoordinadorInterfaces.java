/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package coordinador;

import dto.MesaDTO;
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

}