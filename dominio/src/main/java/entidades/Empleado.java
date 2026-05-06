/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package entidades;

import enums.EstadoMesero;
import enums.RolEmpleado;
import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.codecs.pojo.annotations.BsonRepresentation;


/**
 *
 * @author Alejandra Leal Armenta, 262719
 */

public class Empleado {
    @BsonId
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String id;
    
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private EstadoMesero estado;
    private String user;
    private RolEmpleado rol;

    public Empleado(String id, String nombres, String apellidoPaterno, String apellidoMaterno, EstadoMesero estado, String user, RolEmpleado rol) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.estado = estado;
        this.user = user;
        this.rol = rol;
    }

    public Empleado(String nombres, String apellidoPaterno, String apellidoMaterno, EstadoMesero estado, String user, RolEmpleado rol) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.estado = estado;
        this.user = user;
        this.rol = rol;
    }
    
    
    public Empleado() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public EstadoMesero getEstado() {
        return estado;
    }

    public void setEstado(EstadoMesero estado) {
        this.estado = estado;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public RolEmpleado getRol() {
        return rol;
    }

    public void setRol(RolEmpleado rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", estado=" + estado + ", user=" + user + ", rol=" + rol + '}';
    }
    
    
}
