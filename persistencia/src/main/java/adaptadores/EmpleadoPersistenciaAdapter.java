package adaptadores;

import entidades.Empleado;
import entidadesMongo.EmpleadoEntidadMongo;

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
        mongo.setRol(empleado.getRol());
        mongo.setEstado(empleado.getEstado());

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
        empleado.setRol(mongo.getRol());
        empleado.setEstado(mongo.getEstado());

        return empleado;
    }
}
