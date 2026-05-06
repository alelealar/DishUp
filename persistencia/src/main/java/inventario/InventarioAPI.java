package inventario;

import dto.ProductoDTO;
import dto.IngredienteEnProductoDTO;
import dto.PedidoNuevoDTO;
import enums.TipoProductoDTO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class InventarioAPI {

    private final String BASE_URL = "https://sistema-inventario-3m6j.onrender.com";

    public List<ProductoDTO> obtenerProductos() {
        List<ProductoDTO> lista = new ArrayList<>();

        try {
            URL url = new URL(BASE_URL + "/productos");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            in.close();

            JSONArray array = new JSONArray(response.toString());

            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);

                ProductoDTO dto = new ProductoDTO();
                dto.setId(String.valueOf(obj.getInt("id")));
                dto.setNombre(obj.getString("nombre"));
                dto.setTipo(TipoProductoDTO.valueOf(obj.getString("tipo")));
                dto.setDisponible(obj.getBoolean("disponible"));
                dto.setPrecio((float) obj.optDouble("precio", 0.0));
                dto.setTiempoPreparacion(obj.optInt("tiempoPreparacion", 0));
                dto.setUrlImagen(BASE_URL + obj.optString("imagen", ""));

                // Ingredientes
                if (obj.has("ingredientes")) {
                    JSONArray ingredientesJSON = obj.getJSONArray("ingredientes");
                    List<IngredienteEnProductoDTO> ingredientes = new ArrayList<>();

                    for (int j = 0; j < ingredientesJSON.length(); j++) {
                        JSONObject ing = ingredientesJSON.getJSONObject(j);

                        IngredienteEnProductoDTO dtoIng = new IngredienteEnProductoDTO();
                        dtoIng.setNombre(ing.getString("nombre"));
                        dtoIng.setCantidad(ing.getInt("cantidad"));

                        // si tu API luego agrega "removible"
                        dtoIng.setRemovible(ing.optBoolean("removible", true));

                        ingredientes.add(dtoIng);
                    }

                    dto.setIngredientes(ingredientes);
                }

                lista.add(dto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public ProductoDTO obtenerProductoPorId(String idProducto) {
        List<ProductoDTO> productos = obtenerProductos();

        for (ProductoDTO p : productos) {
            if (p.getId().equals(idProducto)) {
                return p;
            }
        }

        return null;
    }

    public boolean descontarStock(List<PedidoNuevoDTO> pedidos) {
        try {
            URL url = new URL(BASE_URL + "/descontarStock");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            JSONObject body = new JSONObject();
            JSONArray productosArray = new JSONArray();

            for (PedidoNuevoDTO pedido : pedidos) {
                JSONObject obj = new JSONObject();
                obj.put("productoId", Integer.parseInt(pedido.getIdProducto()));
                obj.put("cantidad", pedido.getCantidad());
                productosArray.put(obj);
            }

            body.put("productos", productosArray);

            OutputStream os = conn.getOutputStream();
            os.write(body.toString().getBytes());
            os.flush();
            os.close();

            int responseCode = conn.getResponseCode();

            if (responseCode == 200) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );

                StringBuilder response = new StringBuilder();
                String line;

                while ((line = br.readLine()) != null) {
                    response.append(line);
                }

                JSONObject json = new JSONObject(response.toString());
                return json.getBoolean("exito");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
