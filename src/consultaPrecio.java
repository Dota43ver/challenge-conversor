import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class consultaPrecio {
    public Precio buscaPrecio(){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/de14b46895c6148824eed648/latest/USD");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            ApiResponse apiResponse = new Gson().fromJson(response.body(), ApiResponse.class);
            Precio precio = apiResponse.conversion_rates();
            return precio;
        } catch (Exception e) {
            throw new RuntimeException("No encontré ese precio.");
        }
    }
}
