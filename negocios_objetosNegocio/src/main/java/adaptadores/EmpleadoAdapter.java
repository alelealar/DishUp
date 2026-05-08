/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package adaptadores;

import dto.EmpleadoDTO;
import entidadesMongo.Empleado;
import enums.RolEmpleado;
import enums.EstadoEmpleado;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoAdapter {

    public EmpleadoAdapter() {
    }

    public static EmpleadoDTO toDTO(Empleado empleado) {
        if (empleado == null) {
            return null;
        }

        EmpleadoDTO dto = new EmpleadoDTO();

        dto.setId(empleado.getId());
        dto.setNombres(empleado.getNombres());
        dto.setApellidoPaterno(empleado.getApellidoPaterno());
        dto.setApellidoMaterno(empleado.getApellidoMaterno());

        dto.setUser(empleado.getUser());

        dto.setRol(empleado.getRol().name());
        dto.setEstado(empleado.getEstado().name());

        return dto;
    }

    public static Empleado toEntity(EmpleadoDTO dto) {
        if (dto == null) {
            return null;
        }

        Empleado empleado = new Empleado();

        empleado.setId(dto.getId());
        empleado.setNombres(dto.getNombres());
        empleado.setApellidoPaterno(dto.getApellidoPaterno());
        empleado.setApellidoMaterno(dto.getApellidoMaterno());

        empleado.setUser(dto.getUser());

        empleado.setRol(RolEmpleado.valueOf(dto.getRol()));
        empleado.setEstado(EstadoEmpleado.valueOf(dto.getEstado()));

        return empleado;
    }

    public static List<EmpleadoDTO> listEntityToDTO(List<Empleado> empleados) {
        List<EmpleadoDTO> listaDTO = new ArrayList<>();

        for (Empleado e : empleados) {
            listaDTO.add(toDTO(e));
        }

        return listaDTO;
    }
}
