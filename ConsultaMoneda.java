import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaMoneda {
    private static final String API_KEY = "7741688bb05cc8ea9ce7445f";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    public Moneda buscaMoneda(String monedaBase, String monedaDestino, double cantidad) {
        URI direccion = URI.create(BASE_URL + monedaBase + "/" + monedaDestino);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Moneda resultado = new Gson().fromJson(response.body(), Moneda.class);
            if (resultado != null) {
                resultado.conversion_result = cantidad * resultado.conversion_rate;
            }
            return resultado;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
