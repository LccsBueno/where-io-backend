//package analu.restaurantes_api.adapters.out.external.geocoding.impl;
//
//import analu.restaurantes_api.adapters.out.external.geocoding.record.LatitudeLongitudeRecord;
//import analu.restaurantes_api.application.ports.out.LatitudeLongitudeInterfacePort;
//import org.springframework.stereotype.Component;
//import tools.jackson.databind.JsonNode;
//import tools.jackson.databind.ObjectMapper;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.URLEncoder;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.nio.charset.StandardCharsets;
//
//@Component
//public class LatitudeLongitudeAdapter implements LatitudeLongitudeInterfacePort {
//
//    public LatitudeLongitudeRecord ConverterEnderecoParaCoordenadas(String endereco) throws IOException, InterruptedException {
//        // Codifica o endereço para URL
//        String enderecoCodificado = URLEncoder.encode(endereco, StandardCharsets.UTF_8);
//
//        String url = "https://nominatim.openstreetmap.org/search?format=json&limit=1&q="
//                + enderecoCodificado;
//
//        HttpClient client = HttpClient.newHttpClient();
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .GET()
//                .build();
//
//        HttpResponse<String> response = client.send(request,
//                HttpResponse.BodyHandlers.ofString());
//
//        System.out.println("Status: " + response.statusCode());
//        System.out.println("Resposta JSON:");
//        System.out.println(response.body());
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        // transforma a String JSON em árvore de nós
//        JsonNode root = mapper.readTree(response.body());
//
//        // o retorno do Nominatim é um ARRAY
//        JsonNode primeiroElemento = root.get(0);
//
//        // pega apenas a latitude
//        String latitude = primeiroElemento.get("lat").asText();
//        String longitude = primeiroElemento.get("lon").asText();
//
//        return new LatitudeLongitudeRecord(latitude, longitude);
//    }
//}
