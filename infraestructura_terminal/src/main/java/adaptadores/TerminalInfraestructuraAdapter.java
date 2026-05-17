/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adaptadores;
import org.json.JSONObject;
import dtos_infraestructura.RespuestaTerminalDTO;
import enums.Banco;
import enums.TipoTarjeta;

/**
 *
 * @author valeria
 */
public class TerminalInfraestructuraAdapter {
    public RespuestaTerminalDTO convertirJSONADTO(JSONObject obj) {

        RespuestaTerminalDTO dto = new RespuestaTerminalDTO();

        dto.setAprobado(obj.optBoolean("aprobado", false));
        dto.setMensaje(obj.optString("mensaje", ""));
        dto.setMonto((float) obj.optDouble("monto", 0));
        dto.setNumeroAutorizacion(obj.optString("numeroAutorizacion", ""));
        dto.setUltimos4Digitos(obj.optString("ultimos4Digitos", ""));
        dto.setBanco(
                Banco.valueOf(obj.getString("banco"))
        );

        dto.setTipoTarjeta(
                TipoTarjeta.valueOf(obj.getString("tipoTarjeta"))
        );
        return dto;
    }
}
