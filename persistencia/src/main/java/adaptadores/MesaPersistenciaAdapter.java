/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;

import entidades.Mesa;
import entidadesMongo.MesaEntidadMongo;

/**
 *
 * @author DishUp
 */
public class MesaPersistenciaAdapter {

    public MesaEntidadMongo aMongo(Mesa mesa) {
        if (mesa == null) {
            return null;
        }

        MesaEntidadMongo mongo = new MesaEntidadMongo();

        mongo.setId(mesa.getId());
        mongo.setNumero(mesa.getNumero());
        mongo.setEstado(mesa.getEstado());
        mongo.setIdMesero(mesa.getIdMesero());

        return mongo;
    }

    public Mesa aDominio(MesaEntidadMongo mongo) {
        if (mongo == null) {
            return null;
        }

        return new Mesa(
                mongo.getId(),
                mongo.getNumero(),
                mongo.getEstado(),
                mongo.getIdMesero()
        );
    }
}
