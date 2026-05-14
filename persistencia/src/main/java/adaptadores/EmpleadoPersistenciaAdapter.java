package adaptadores;

import entidades.Empleado;
import entidadesMongo.EmpleadoEntidadMongo;
import enums.EstadoEmpleado;
import enums.RolEmpleado;

public class EmpleadoPersistenciaAdapter {

    public EmpleadoPersistenciaAdapter() {
    }

    public EmpleadoEntidadMongo aMongo(Empleado empleado) {

        if (empleado == null) {
            return null;
        }

        EmpleadoEntidadMongo mongo = new EmpleadoEntidadMongo();

        mongo.setId(empleado.getId());
        mongo.setNombres(empleado.getNombres());
        mongo.setApellidoPaterno(empleado.getApellidoPaterno());
        mongo.setApellidoMaterno(empleado.getApellidoMaterno());
        mongo.setUser(empleado.getUser());
        mongo.setRol(empleado.getRol().name());
        mongo.setEstado(empleado.getEstado().name());

        return mongo;
    }

    public Empleado aDominio(EmpleadoEntidadMongo mongo) {

        if (mongo == null) {
            return null;
        }

        Empleado empleado = new Empleado();

        empleado.setId(mongo.getId());
        empleado.setNombres(mongo.getNombres());
        empleado.setApellidoPaterno(mongo.getApellidoPaterno());
        empleado.setApellidoMaterno(mongo.getApellidoMaterno());
        empleado.setUser(mongo.getUser());
        empleado.setRol(RolEmpleado.valueOf(mongo.getRol().toUpperCase()));
        empleado.setEstado(EstadoEmpleado.valueOf(mongo.getEstado().toUpperCase()));

        return empleado;
    }
}
