package cat.institut.model;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

public class TasquesModel {

    private final HttpClient client;

    // IMPORTANT: amb /api
    private final String BASE_URL = "https://m6-uf-3-api-1fax-inktpiu83-josues-projects-de45d7d2.vercel.app/api";

    public TasquesModel() {
        client = HttpClient.newHttpClient();
    }

    /**
     * Crear una nova tasca (POST)
     */
    public CompletableFuture<String> inserirTasca(String nom,
            String cognom1,
            String cognom2,
            Date dataEntrada,
            boolean completa,
            String observacions) {

        String json = String.format(
                "{\"nom\":\"%s\",\"cognom1\":\"%s\",\"cognom2\":\"%s\",\"dataEntrada\":\"%s\",\"observacions\":\"%s\",\"completa\":%b}",
                nom,
                cognom1,
                cognom2,
                dataEntrada.toInstant().toString(),
                observacions,
                completa);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/tasques"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }

    /**
     * Obtenir totes les tasques (GET)
     */
    public CompletableFuture<String> getAllTasques() {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/tasques"))
                .GET()
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }

    /**
     * Eliminar tasca (DELETE)
     */
    public CompletableFuture<String> deleteTasca(String id) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/tasques/" + id))
                .DELETE()
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }

    /**
     * Actualitzar tasca (PATCH)
     */
    public CompletableFuture<String> updateTasca(String id,
            String nom,
            String cognom1,
            String cognom2,
            Date dataEntrada,
            boolean completa,
            String observacions) {

        String json = String.format(
                "{\"nom\":\"%s\",\"cognom1\":\"%s\",\"cognom2\":\"%s\",\"dataEntrada\":\"%s\",\"observacions\":\"%s\",\"completa\":%b}",
                nom,
                cognom1,
                cognom2,
                dataEntrada.toInstant().toString(),
                observacions,
                completa);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/tasques/" + id))
                .header("Content-Type", "application/json")
                .method("PATCH", HttpRequest.BodyPublishers.ofString(json))
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }
}
