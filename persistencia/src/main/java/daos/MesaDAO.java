package daos;

import adaptadores.MesaPersistenciaAdapter;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.InsertOneResult;
import conexion.ConexionMongo;
import entidades.Mesa;
import entidadesMongo.MesaEntidadMongo;
import excepciones.PersistenciaException;
import interfaces.IMesaDAO;
import java.util.ArrayList;
import java.util.List;

public class MesaDAO implements IMesaDAO {

    private final MongoCollection<MesaEntidadMongo> coleccion;
    private final MesaPersistenciaAdapter mesaAdapter;

    public MesaDAO() {
        this.coleccion = ConexionMongo.obtenerBaseDatos()
                .getCollection("mesas", MesaEntidadMongo.class);
        this.mesaAdapter = new MesaPersistenciaAdapter();
    }

    @Override
    public List<Mesa> obtenerMesasPorMesero(String idMesero) throws PersistenciaException {
        if (idMesero == null || idMesero.isBlank()) {
            return new ArrayList<>();
        }

        try {
            List<MesaEntidadMongo> mesasMongo = coleccion
                    .find(eq("idMesero", idMesero))
                    .into(new ArrayList<>());

            List<Mesa> mesasDominio = new ArrayList<>();

            for (MesaEntidadMongo mesaMongo : mesasMongo) {
                mesasDominio.add(mesaAdapter.aDominio(mesaMongo));
            }

            return mesasDominio;

        } catch (MongoException ex) {
            throw new PersistenciaException("No fue posible obtener las mesas del mesero.", ex);
        }
    }

    @Override
    public Mesa insertarMesa(Mesa mesa) throws PersistenciaException {
        if (mesa == null) {
            throw new PersistenciaException("La mesa es nula");
        }

        try {
            MesaEntidadMongo mesaMongo = mesaAdapter.aMongo(mesa);

            InsertOneResult resultado = this.coleccion.insertOne(mesaMongo);

            if (resultado.getInsertedId() == null) {
                throw new PersistenciaException("Error al guardar");
            }

            String idGenerado = resultado.getInsertedId()
                    .asObjectId()
                    .getValue()
                    .toHexString();

            mesaMongo.setId(idGenerado);

            return mesaAdapter.aDominio(mesaMongo);

        } catch (MongoException ex) {
            throw new PersistenciaException("No fue posible insertar la mesa.", ex);
        }
    }
}