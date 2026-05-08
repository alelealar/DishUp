/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coordinador;


import control.ComandaControl;
import control.EmpleadoControl;
import control.ProductoControl;
import dto.ComandaDTO;
import dto.EmpleadoDTO;
import dto.IngredienteEnProductoDTO;
import dto.MesaDTO;
import dto.PedidoNuevoDTO;
import dto.ProductoDTO;
import excepciones.NegocioException;
import fabricas.FabricaComandas;
import fabricas.FabricaEmpleados;
import fabricas.FabricaProductos;
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

    private ProductoControl productoControl; // Se pone el control aquí para que las pantallas (FrmProductos) no tengan que crearlo ellas mismas, 
    private ComandaControl comandaControl; // Se pone el control aquí para que las pantallas (FrmProductos) no tengan que crearlo ellas mismas, 
    private EmpleadoControl empleadoControl;

    public CoordinadorInterfaces() {
        // El Coordinador es el mediador, conoce el ProductoControl para poder 
        // inyectarlo en las ventanas que lo necesiten

        this.productoControl = FabricaProductos.crear();
        this.comandaControl = FabricaComandas.crear(productoControl);
        this.empleadoControl = FabricaEmpleados.crear();
        
        //this.inventarioAPI = new InventarioAPI();

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

        try {
            comandaControl.crearComanda(nombreCliente, numeroMesa, pedidos);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
//
//        comandasPorMesa
//                .computeIfAbsent(numeroMesa, k -> new ArrayList<>())
//                .add(nuevaComanda);

        this.frmComandas.setVisible(true);
        this.frmComandas.refrescarMesaActual();

        if (this.frmProductos != null) {
            this.frmProductos.dispose();
            this.frmProductos = null;
        }

        comandaTemporal.clear();
    }

    public List<ComandaDTO> getComandasDeMesa(int numeroMesa) {
        return comandaControl.obtenerComandasPorMesa(numeroMesa);
    }

    public List<ProductoDTO> obtenerProductosParaUI() {
        List<ProductoDTO> productosAPI = productoControl.obtenerProductos();
        // System.out.println("Productos API: " + productosAPI.size());

//        for (ProductoDTO p : productosAPI) {
//            System.out.println(p.toString());
//        }
        return productosAPI;
    }
    
    public EmpleadoDTO validarExistenciaUsuario(EmpleadoDTO e) throws NegocioException{
        return empleadoControl.login(e);
    }
    
    public void abrirFrmComandasMesero(String id, String nombre){
        FrmPantallaComandas frm = new FrmPantallaComandas(this);
        frm.setMesero(id, nombre);
        frm.cargarMesas();
        frm.setVisible(true);
    }
    
    public void activarEmpleado(EmpleadoDTO e) throws NegocioException{
        empleadoControl.activarEmpleado(e);
    }

}
