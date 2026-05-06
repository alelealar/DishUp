/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coordinador;

import control.ProductoControl;
import dto.ComandaDTO;
import dto.IngredienteDTO;
import dto.IngredienteEnProductoDTO;
import dto.MesaDTO;
import dto.PedidoNuevoDTO;
import dto.ProductoDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    private Map<Integer, List<ComandaDTO>> comandasPorMesa = new HashMap<>();
    private ProductoControl productoControl; // Se pone el control aquí para que las pantallas (FrmProductos) no tengan que crearlo ellas mismas, 
                                             // manteniendo la UI 100% libre de lógica de negocio o de base de datos

    public CoordinadorInterfaces() {
        // El Coordinador es el mediador, conoce el ProductoControl para poder 
        // inyectarlo en las ventanas que lo necesiten
        this.productoControl = productoControl;
    }

    
    public void setFrmProductos(FrmProductos frmProductos) {
        this.frmProductos = frmProductos;
    }

    public void setFrmComandas(FrmPantallaComandas frmComandas) {
        this.frmComandas = frmComandas;
    }

    private List<PedidoNuevoDTO> comandaTemporal = new ArrayList<>();

    public void mostrarRegistrarCliente(MesaDTO mesa) {
        frmCliente = new FrmCliente(this);
        comandaTemporal.clear();
        // frmCliente = new FrmCliente();
        frmCliente.setNumeroMesa(mesa.getNumeroMesa());
        frmCliente.setVisible(true);
    }

    public void regresarFrmComandas() {
        if (this.frmComandas != null) {
            this.frmComandas.setVisible(true);
        }
    }

    public void frmClienteAFrmProductos(Integer mesa, String nombreCliente) {
        frmProductos = new FrmProductos(this, this.productoControl); // Aqui se agrega el ProductoControl
        frmProductos.setMesaAndCliente(mesa, nombreCliente);
        frmProductos.setVisible(true);
    }

    public void frmProductosAFrmCliente(String nombreCliente, Integer numMesa) {
        frmCliente = new FrmCliente(this);
        frmCliente.setNombreCliente(nombreCliente);
        frmCliente.setNumeroMesa(numMesa);
        frmCliente.setVisible(true);
    }

    public void abrirPersonalizacionProducto(FrmProductos frm, ProductoDTO producto, List<IngredienteEnProductoDTO> removibles) {

        DlgModificarProducto dlg = new DlgModificarProducto(frm, producto, removibles);
        dlg.setVisible(true);

        PedidoNuevoDTO pedido = dlg.getResultado();

        if (pedido != null) {
            comandaTemporal.add(pedido);
            frm.agregarPedidoVisual(pedido);
        }
    }

    public void abrirResumenComanda(FrmProductos frm, int mesa, String nombreCliente) {
        DlgResumenComanda dlg = new DlgResumenComanda(this, frm, comandaTemporal, mesa, nombreCliente);
        dlg.setMesaAndCliente(mesa, nombreCliente);
        dlg.setVisible(true);

    }

    public void enviarComandaAFinal(String nombreCliente, int numeroMesa, List<PedidoNuevoDTO> pedidos) {
        System.out.println("frmComandas: " + frmComandas);
        ComandaDTO nuevaComanda = new ComandaDTO(
                nombreCliente,
                java.time.LocalDate.now(),
                new ArrayList<>(pedidos),
                numeroMesa
        );

        // Guardar en el mapa por mesa
        comandasPorMesa
                .computeIfAbsent(numeroMesa, k -> new ArrayList<>())
                .add(nuevaComanda);

        this.frmComandas.setVisible(true);
        this.frmComandas.refrescarMesaActual();

//        this.frmComandas.mostrarComandasDeMesa(numeroMesa, comandasPorMesa.get(numeroMesa));
//        this.frmComandas.quitarLabels();
//        this.frmComandas.botonesVisibles();
//        this.frmComandas.setVisible(true);
        if (this.frmProductos != null) {
            this.frmProductos.dispose();
            this.frmProductos = null;
        }

        comandaTemporal.clear();
    }

    public List<ComandaDTO> getComandasDeMesa(int numeroMesa) {
        return comandasPorMesa.getOrDefault(numeroMesa, new ArrayList<>());
    }

}
