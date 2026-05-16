/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package daos;
/*
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import conexion.ConexionMongo;
import entidades.Empleado;
import entidades.Mesa;
import entidadesMongo.EmpleadoEntidadMongo;
import enums.EstadoEmpleado;
import enums.EstadoMesa;
import enums.RolEmpleado;
import excepciones.PersistenciaException;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
*/
/**
 *
 * @author DishUp
 */

/*
public class MesaDAONGTest {

    @AfterEach
    public void limpiar() {
        ConexionMongo.obtenerBaseDatos()
                .getCollection("mesas")
                .deleteMany(new Document());

        ConexionMongo.obtenerBaseDatos()
                .getCollection("empleados")
                .deleteMany(new Document());
    }

    @Test
    public void insertarMesa_correcto() throws PersistenciaException {
        MesaDAO mdao = new MesaDAO();

        Mesa mesa1 = new Mesa(1, EstadoMesa.LIBRE);
        Mesa mesa2 = new Mesa(2, EstadoMesa.LIBRE);

        mdao.insertarMesa(mesa1);
        mdao.insertarMesa(mesa2);

        Mesa mesa1Obtenida = mdao.obtenerMesa(mesa1);
        Mesa mesa2Obtenida = mdao.obtenerMesa(mesa2);

        assertNotNull(mesa1Obtenida);
        assertNotNull(mesa2Obtenida);
    }

    @Test
    public void insertarMesa_mesaNull() throws PersistenciaException {
        MesaDAO mdao = new MesaDAO();

        assertThrows(PersistenciaException.class, () -> {
            mdao.insertarMesa(null);
        });
    }

    @Test
    public void testObtenerMesasPorMesero_correcto() throws PersistenciaException {

        MesaDAO mdao = new MesaDAO();

        MongoCollection<EmpleadoEntidadMongo> coleccion
                = ConexionMongo.obtenerBaseDatos()
                        .getCollection("empleados", EmpleadoEntidadMongo.class);

        EmpleadoEntidadMongo empleadoMongo = new EmpleadoEntidadMongo();

        empleadoMongo.setNombres("Alejandra");
        empleadoMongo.setApellidoPaterno("Leal");
        empleadoMongo.setApellidoMaterno("Armenta");
        empleadoMongo.setUser("ME-001");
        empleadoMongo.setRol(RolEmpleado.MESERO.name());
        empleadoMongo.setEstado(EstadoEmpleado.ACTIVO.name());

        InsertOneResult resultado = coleccion.insertOne(empleadoMongo);

        String idMesero = resultado.getInsertedId()
                .asObjectId()
                .getValue()
                .toHexString();

        Mesa mesa1 = new Mesa(1, EstadoMesa.LIBRE);
        mesa1.setIdMesero(idMesero);

        Mesa mesa2 = new Mesa(2, EstadoMesa.LIBRE);
        mesa2.setIdMesero(idMesero);

        mdao.insertarMesa(mesa1);
        mdao.insertarMesa(mesa2);

        List<Mesa> mesas = mdao.obtenerMesasPorMesero(idMesero);

        assertEquals(mesas.get(0).getIdMesero(), idMesero);
        assertEquals(mesas.get(1).getIdMesero(), idMesero);

        assertEquals(mesas.size(), 2);
    }

    @Test
    public void testEliminarMesa_correcto() throws PersistenciaException {

        MesaDAO mdao = new MesaDAO();

        Mesa mesa = new Mesa(1, EstadoMesa.LIBRE);

        mdao.insertarMesa(mesa);

        Mesa mesaObtenida = mdao.obtenerMesa(mesa);

        assertNotNull(mesaObtenida);

        mdao.eliminarMesa(mesa);

        assertThrows(PersistenciaException.class, () -> {
            mdao.obtenerMesa(mesa);
        });
    }

    @Test
    public void testEliminarMesa_mesaNull() throws PersistenciaException {

        MesaDAO mdao = new MesaDAO();

        assertThrows(PersistenciaException.class, () -> {
            mdao.eliminarMesa(null);
        });
    }

    @Test
    public void testEliminarMesa_mesaNoEncontrada() throws PersistenciaException {

        MesaDAO mdao = new MesaDAO();

        Mesa mesa = new Mesa(1, EstadoMesa.LIBRE);

        assertThrows(PersistenciaException.class, () -> {
            mdao.eliminarMesa(mesa);
        });
    }

    @Test
    public void testObtenerMesa_correcto() throws PersistenciaException {

        MesaDAO mdao = new MesaDAO();

        Mesa mesa = new Mesa(1, EstadoMesa.LIBRE);

        mdao.insertarMesa(mesa);

        Mesa mesaObtenida = mdao.obtenerMesa(mesa);

        assertNotNull(mesaObtenida);
        assertEquals(mesa.getId(), mesaObtenida.getId());
    }

    @Test
    public void testObtenerMesa_mesaNull() throws PersistenciaException {

        MesaDAO mdao = new MesaDAO();

        assertThrows(PersistenciaException.class, () -> {
            mdao.obtenerMesa(null);
        });
    }

    @Test
    public void testObtenerMesa_mesaNoEncontrada() throws PersistenciaException {

        MesaDAO mdao = new MesaDAO();

        Mesa mesa = new Mesa(1, EstadoMesa.LIBRE);

        assertThrows(PersistenciaException.class, () -> {
            mdao.obtenerMesa(mesa);
        });
    }

    @Test
    public void testAsignarMesaAMesero_correcto() throws PersistenciaException {

        MesaDAO mdao = new MesaDAO();

        MongoCollection<EmpleadoEntidadMongo> coleccion
                = ConexionMongo.obtenerBaseDatos()
                        .getCollection("empleados", EmpleadoEntidadMongo.class);

        EmpleadoEntidadMongo empleadoMongo = new EmpleadoEntidadMongo();

        empleadoMongo.setNombres("Alejandra");
        empleadoMongo.setApellidoPaterno("Leal");
        empleadoMongo.setApellidoMaterno("Armenta");
        empleadoMongo.setUser("ME-001");
        empleadoMongo.setRol(RolEmpleado.MESERO.name());
        empleadoMongo.setEstado(EstadoEmpleado.ACTIVO.name());

        InsertOneResult resultado = coleccion.insertOne(empleadoMongo);

        String idMesero = resultado.getInsertedId()
                .asObjectId()
                .getValue()
                .toHexString();
        
        Empleado empleado = new Empleado(
                idMesero,
                "Alejandra",
                "Leal",
                "Armenta",
                "ME-001",
                RolEmpleado.MESERO,
                EstadoEmpleado.ACTIVO
        );

        Mesa mesa = new Mesa(1, EstadoMesa.LIBRE);
        mdao.insertarMesa(mesa);
        
        mdao.asignarMesaAMesero(mesa, empleado);
        Mesa mesaObtenida = mdao.obtenerMesa(mesa);

        assertEquals(idMesero,mesaObtenida.getIdMesero());
    }
    
    @Test
    public void testObtenerMesasDisponibles_correcto() throws PersistenciaException{
        MesaDAO mdao = new MesaDAO();
        
        MongoCollection<EmpleadoEntidadMongo> coleccion
                = ConexionMongo.obtenerBaseDatos()
                        .getCollection("empleados", EmpleadoEntidadMongo.class);

        EmpleadoEntidadMongo empleadoMongo = new EmpleadoEntidadMongo();

        empleadoMongo.setNombres("Alejandra");
        empleadoMongo.setApellidoPaterno("Leal");
        empleadoMongo.setApellidoMaterno("Armenta");
        empleadoMongo.setUser("ME-001");
        empleadoMongo.setRol(RolEmpleado.MESERO.name());
        empleadoMongo.setEstado(EstadoEmpleado.ACTIVO.name());

        InsertOneResult resultado = coleccion.insertOne(empleadoMongo);

        String idMesero = resultado.getInsertedId()
                .asObjectId()
                .getValue()
                .toHexString();
        

        Mesa mesa1 = new Mesa(1, EstadoMesa.LIBRE);
        Mesa mesa2 = new Mesa(2, EstadoMesa.OCUPADA);
        Mesa mesa3 = new Mesa(3, EstadoMesa.LIBRE);
        Mesa mesa4 = new Mesa(4, EstadoMesa.OCUPADA);
        Mesa mesa5 = new Mesa(5, EstadoMesa.LIBRE);
        
        mesa1.setIdMesero(idMesero);
        mesa3.setIdMesero(idMesero);
        
        mdao.insertarMesa(mesa1);
        mdao.insertarMesa(mesa2);
        mdao.insertarMesa(mesa3);
        mdao.insertarMesa(mesa4);
        mdao.insertarMesa(mesa5);
        
        List<Mesa> disponibles = mdao.obtenerMesasDisponibles();
        
        assertEquals(3, disponibles.size());
    }
    
    @Test
    public void testObtenerMesasDisponibles_sinMesasDisponibles() throws PersistenciaException{
        MesaDAO mdao = new MesaDAO();
        
        MongoCollection<EmpleadoEntidadMongo> coleccion
                = ConexionMongo.obtenerBaseDatos()
                        .getCollection("empleados", EmpleadoEntidadMongo.class);

        EmpleadoEntidadMongo empleadoMongo = new EmpleadoEntidadMongo();

        empleadoMongo.setNombres("Alejandra");
        empleadoMongo.setApellidoPaterno("Leal");
        empleadoMongo.setApellidoMaterno("Armenta");
        empleadoMongo.setUser("ME-001");
        empleadoMongo.setRol(RolEmpleado.MESERO.name());
        empleadoMongo.setEstado(EstadoEmpleado.ACTIVO.name());

        InsertOneResult resultado = coleccion.insertOne(empleadoMongo);

        String idMesero = resultado.getInsertedId()
                .asObjectId()
                .getValue()
                .toHexString();
        

        Mesa mesa1 = new Mesa(1, EstadoMesa.LIBRE);
        Mesa mesa2 = new Mesa(2, EstadoMesa.OCUPADA);
        Mesa mesa3 = new Mesa(3, EstadoMesa.LIBRE);
        Mesa mesa4 = new Mesa(4, EstadoMesa.OCUPADA);
        Mesa mesa5 = new Mesa(5, EstadoMesa.LIBRE);
        
        mesa1.setIdMesero(idMesero);
        mesa2.setIdMesero(idMesero);
        mesa3.setIdMesero(idMesero);
        mesa4.setIdMesero(idMesero);
        mesa5.setIdMesero(idMesero);
        
        mdao.insertarMesa(mesa1);
        mdao.insertarMesa(mesa2);
        mdao.insertarMesa(mesa3);
        mdao.insertarMesa(mesa4);
        mdao.insertarMesa(mesa5);
        
        List<Mesa> disponibles = mdao.obtenerMesasDisponibles();
        
        assertEquals(0, disponibles.size());
    }
}
*/