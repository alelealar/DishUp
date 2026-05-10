
package daos;

import adaptadores.EmpleadoPersistenciaAdapter;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.InsertOneResult;
import conexion.ConexionMongo;
import entidades.Empleado;
import entidadesMongo.EmpleadoEntidadMongo;
import enums.EstadoEmpleado;
import excepciones.PersistenciaException;
import interfaces.IEmpleadoDAO;
import org.bson.types.ObjectId;

public class EmpleadoDAO implements IEmpleadoDAO {

    private final MongoCollection<EmpleadoEntidadMongo> coleccion;
    private final EmpleadoPersistenciaAdapter empleadoAdapter;

    public EmpleadoDAO() {
        this.coleccion = ConexionMongo.obtenerBaseDatos().getCollection("empleados", EmpleadoEntidadMongo.class);
        this.empleadoAdapter = new EmpleadoPersistenciaAdapter();
    }

    @Override
    public Empleado insertarEmpleado(Empleado empleado) throws PersistenciaException {
        if (empleado == null) {
            throw new PersistenciaException("El empleado es nulo");
        }

        try {
            EmpleadoEntidadMongo empleadoMongo = empleadoAdapter.aMongo(empleado);

            InsertOneResult resultado = this.coleccion.insertOne(empleadoMongo);

            if (resultado.getInsertedId() == null) {
                throw new PersistenciaException("Error al guardar");
            }

            String idGenerado = resultado.getInsertedId().asObjectId().getValue().toHexString();

            empleadoMongo.setId(idGenerado);

            return empleadoAdapter.aDominio(empleadoMongo);

        } catch (MongoException ex) {
            throw new PersistenciaException("No fue posible insertar el empleado.", ex);
        }
    }

    @Override
    public Empleado obtenerEmpleado(Empleado empleado) throws PersistenciaException {
        if (empleado == null) {
            throw new PersistenciaException("El empleado es nulo");
        }

        if (empleado.getId() == null || empleado.getId().isBlank()) {
            throw new PersistenciaException("El ID del empleado es inválido");
        }

        try {
            EmpleadoEntidadMongo empleadoMongo = this.coleccion.find(
                    eq("_id", new ObjectId(empleado.getId()))
            ).first();

            return empleadoAdapter.aDominio(empleadoMongo);

        } catch (MongoException ex) {
            throw new PersistenciaException("No fue posible obtener el empleado.", ex);
        }
    }

    @Override
    public Empleado obtenerEmpleadoPorUser(String user) throws PersistenciaException {
        if (user == null || user.isBlank()) {
            throw new PersistenciaException("El usuario es inválido");
        }

        try {
            EmpleadoEntidadMongo empleadoMongo = coleccion.find(eq("user", user)).first();

            return empleadoAdapter.aDominio(empleadoMongo);

        } catch (MongoException ex) {
            throw new PersistenciaException("No fue posible obtener el empleado.", ex);
        }
    }

    @Override
    public void actualizarEstadoEmpleado(String id, EstadoEmpleado estado) throws PersistenciaException {
        if (id == null || id.isBlank()) {
            throw new PersistenciaException("ID inválido");
        }

        if (estado == null) {
            throw new PersistenciaException("Estado inválido");
        }

        try {
            coleccion.updateOne(
                    eq("_id", new ObjectId(id)),
                    set("estado", estado)
            );

        } catch (MongoException ex) {
            throw new PersistenciaException("No fue posible actualizar el estado del empleado.", ex);
        }
    }

}