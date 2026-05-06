///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
// */
//package daos;
//
//import conexion.ConexionMongo;
//import entidades.Empleado;
//import entidades.Mesa;
//import enums.EstadoMesa;
//import enums.EstadoMesero;
//import enums.RolEmpleado;
//import excepciones.PersistenciaException;
//import java.util.List;
//import org.bson.Document;
//import org.junit.jupiter.api.AfterEach;
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
//
///**
// *
// * @author DishUp
// */
//public class MesaDAONGTest {
//    
//    @AfterEach
//    public void limpiar() {
//        ConexionMongo.obtenerBaseDatos()
//            .getCollection("mesas")
//            .deleteMany(new Document());
//
//        ConexionMongo.obtenerBaseDatos()
//            .getCollection("empleados")
//            .deleteMany(new Document());
//    }
//    
//    @Test
//    public void insertarMesa_correcto() throws PersistenciaException{
//        MesaDAO mdao = new MesaDAO();
//        Mesa mesa1 = new Mesa(1, EstadoMesa.LIBRE);
//        Mesa mesa2 = new Mesa(2, EstadoMesa.LIBRE);
//        
//        Mesa mesa1Insert = mdao.insertarMesa(mesa1);
//        Mesa mesa2Insert = mdao.insertarMesa(mesa2);
//        
//        assertNotNull(mesa1Insert.getId());
//        assertNotNull(mesa2Insert.getId());
//    } 
//    
//    @Test
//    public void testObtenerMesasPorMesero_correcto() throws PersistenciaException{
//        MesaDAO mdao = new MesaDAO();
//        
//        EmpleadoDAO emDAO = new EmpleadoDAO();
//        Empleado empleado = new Empleado("Alejansra", "Leal", "Armenta", EstadoMesero.ACTIVO, "ME-001", RolEmpleado.MESERO);
//        Empleado emInsert = emDAO.insertarEmpleado(empleado);
//        Mesa mesa1 = new Mesa(1, EstadoMesa.LIBRE);
//        mesa1.setIdMesero(emInsert.getId());
//        Mesa mesa2 = new Mesa(2, EstadoMesa.LIBRE);
//        mesa2.setIdMesero(emInsert.getId());
//        
//        Mesa mesa1Insert = mdao.insertarMesa(mesa1);
//        Mesa mesa2Insert = mdao.insertarMesa(mesa2);
//        
//        List<Mesa> mesas = mdao.obtenerMesasPorMesero(emInsert.getId());
//        assertEquals(mesas.get(0).getId(), mesa1Insert.getId());
//        assertEquals(mesas.get(0).getIdMesero(), emInsert.getId());
//        assertEquals(mesas.get(1).getId(), mesa2Insert.getId());
//        assertEquals(mesas.get(1).getIdMesero(), emInsert.getId());
//        assertEquals(mesas.size(), 2);
//             
//    }
//    
//}
