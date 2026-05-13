/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coordinador;

import dtos.ComandaDTO;
import dtos.EmpleadoDTO;
import dtos.IngredienteEnProductoDTO;
import dtos.MesaDTO;
import dtos.PedidoDTO;
import dtos.ProductoDTO;
import excepcion.NegocioException;
import fachada.ComandaFachada;
import fachada.EmpleadoFachada;
import fachada.MesaFachada;
import fachada.ProductoFachada;
import interfaces.IGestionComandas;
import interfaz.IGestionEmpleados;
import interfaz.IGestionMesas;
import interfaz.IGestionProductos;
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

    private EmpleadoDTO empleadoActual;
    private ComandaDTO comandaActual;

    private FrmPantallaComandas frmComandas;
    private FrmCliente frmCliente;
    private FrmProductos frmProductos;

    private IGestionProductos productoFachada;
    private IGestionComandas comandaFachada;
    private IGestionEmpleados empleadoFachada;
    private IGestionMesas mesaFachada;

    public CoordinadorInterfaces() {
        this.productoFachada = new ProductoFachada();
        this.comandaFachada = new ComandaFachada();
        this.empleadoFachada = new EmpleadoFachada();
        this.mesaFachada = new MesaFachada();
    }

    public void setFrmProductos(FrmProductos frmProductos) {
        this.frmProductos = frmProductos;
    }

    public void setFrmComandas(FrmPantallaComandas frmComandas) {
        this.frmComandas = frmComandas;
    }

    private List<PedidoDTO> comandaTemporal = new ArrayList<>();

    public void mostrarRegistrarCliente(MesaDTO mesa) {
        frmCliente = new FrmCliente(this);
        comandaTemporal = new ArrayList<>();
        frmCliente.setNumeroMesa(mesa.getNumeroMesa());
        frmCliente.setVisible(true);
    }

    public void regresarFrmComandas() {
        if (this.frmComandas != null) {
            this.frmComandas.setVisible(true);
        }
    }

    public void frmClienteAFrmProductos(Integer mesa, String nombreCliente) {
        frmProductos = new FrmProductos(this);
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

        PedidoDTO pedido = dlg.getResultado();

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

    public void enviarComandaAFinal(String nombreCliente, int numeroMesa, List<PedidoDTO> pedidos) {
        try {
            comandaFachada.crearComanda(nombreCliente, numeroMesa, pedidos, empleadoActual);

            this.frmComandas.setVisible(true);
            this.frmComandas.refrescarMesaActual();

            if (this.frmProductos != null) {
                this.frmProductos.dispose();
                this.frmProductos = null;
            }

            comandaTemporal.clear();

        } catch (NegocioException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<ComandaDTO> getComandasDeMesa(int numeroMesa) {
        try {
            return comandaFachada.obtenerComandasPorMesa(numeroMesa);
        } catch (NegocioException e) {
            System.out.println("Error al obtener comandas: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<ProductoDTO> obtenerProductosParaUI() {
        try {
            return productoFachada.obtenerProductos();
        } catch (NegocioException e) {
            System.out.println("Error al obtener productos: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public EmpleadoDTO validarExistenciaUsuario(EmpleadoDTO e) throws NegocioException {
        empleadoActual = empleadoFachada.login(e);
        return empleadoActual;
    }

    public void abrirFrmComandasMesero(String id, String nombre) {
        // FrmPantallaComandas frm = new FrmPantallaComandas(this);
        frmComandas = new FrmPantallaComandas(this);
        frmComandas.setMesero(id, nombre);
        frmComandas.cargarMesas();
        frmComandas.setVisible(true);
        frmComandas.setMesero(id, nombre);
        frmComandas.setVisible(true);
    }

    public void activarEmpleado(EmpleadoDTO e) throws NegocioException {
        empleadoFachada.activarEmpleado(e);
    }

    public List<IngredienteEnProductoDTO> obtenerIngredientesRemovibles(String idProducto) {
        try {
            return productoFachada.obtenerIngredientesRemovibles(idProducto);
        } catch (NegocioException e) {
            System.out.println("Error al obtener ingredientes removibles: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void eliminarPedidoTemporal(PedidoDTO pedido) {
        comandaTemporal.remove(pedido);
    }

    public void abrirAgregarPedido(ComandaDTO comanda) {

        this.comandaActual = comanda;

        FrmProductos frm = new FrmProductos(this);

        frm.setMesaAndCliente(
                comanda.getNumMesa(),
                comanda.getNombreCliente()
        );

        frm.cargarPedidosExistentes(comanda);

        frm.setVisible(true);
    }

    public void agregarPedidosAComanda(ComandaDTO comanda, int numeroMesa, String nombreCliente) {
        try {

            for (PedidoDTO pedido : comandaTemporal) {
                comanda.getPedidos().add(pedido);
            }

            comandaFachada.agregarPedidosAComanda(comanda.getId(), comandaTemporal);

            this.frmComandas.refrescarMesaActual();

            if (this.frmProductos != null) {
                this.frmProductos.dispose();
                this.frmProductos = null;
            }

            comandaTemporal.clear();

        } catch (NegocioException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void abrirResumenAgregarPedido(ComandaDTO comanda) {

        List<PedidoDTO> pedidosExistentes = comanda.getPedidos();

        DlgResumenComanda dlg = new DlgResumenComanda(
                this,
                frmProductos,
                pedidosExistentes,
                comandaTemporal,
                comanda.getNumMesa(),
                comanda.getNombreCliente(),
                true,
                comanda
        );

        dlg.setVisible(true);
    }
}
