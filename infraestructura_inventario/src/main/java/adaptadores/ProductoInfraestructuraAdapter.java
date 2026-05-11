package adaptadores;

import dtos_infraestructura.IngredienteDTOInfraestructura;
import dtos_infraestructura.ProductoDTOInfraestructura;
import enums.TipoProductoDTOInfraestructura;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ProductoInfraestructuraAdapter {

    public ProductoInfraestructuraAdapter() {
    }

    public ProductoDTOInfraestructura convertirJSONADTO(JSONObject obj, String baseURL) {

        if (obj == null) {
            return null;
        }

        ProductoDTOInfraestructura dto = new ProductoDTOInfraestructura();

        dto.setId(String.valueOf(obj.getInt("id")));
        dto.setNombre(obj.getString("nombre"));
        dto.setTipo(TipoProductoDTOInfraestructura.valueOf(obj.getString("tipo")));
        dto.setDisponible(obj.getBoolean("disponible"));
        dto.setPrecio((float) obj.optDouble("precio", 0.0));
        dto.setTiempoPreparacion(obj.optInt("tiempoPreparacion", 0));
        dto.setUrlImagen(baseURL + obj.optString("imagen", ""));
        List<IngredienteDTOInfraestructura> ingredientes = new ArrayList<>();

        if (obj.has("ingredientes")) {
            
            JSONArray ingredientesJSON = obj.getJSONArray("ingredientes");

            for (int i = 0; i < ingredientesJSON.length(); i++) {
                JSONObject ing = ingredientesJSON.getJSONObject(i);
                IngredienteDTOInfraestructura dtoIng = new IngredienteDTOInfraestructura();
                dtoIng.setNombre(ing.getString("nombre"));
                dtoIng.setCantidad(ing.getInt("cantidad"));
                dtoIng.setRemovible(ing.optBoolean("removible", true));
                ingredientes.add(dtoIng);
            }
        }

        dto.setIngredientes(ingredientes);
        
        return dto;
    }
}
