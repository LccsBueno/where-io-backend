package analu.restaurantes_api.adapters.out.external.geocoding.impl;

import analu.restaurantes_api.adapters.out.persistence.entity.RestauranteEntity;
import analu.restaurantes_api.application.model.Endereco;
import analu.restaurantes_api.application.ports.out.GeocodingPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import tools.jackson.databind.JsonNode;

@Service
@RequiredArgsConstructor
public class GoogleGeocodingTextSearchAdapter implements GeocodingPort {

    private final RestTemplate restTemplate;

    @Override
    public RestauranteEntity buscarRestaurantePorEnderecoENome(String input) {
        String apikey = "AIzaSyDjxmuJz8jqAl3hGWk5iinFc1u7ezRaTjU";

        String url = "https://places.googleapis.com/v1/places:searchText";

// Body obrigatório na v1
        String requestBody = """
        {
          "textQuery": "%s"
        }
        """.formatted(input);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Goog-Api-Key", apikey);

        // Pegando também latitude e longitude (importante!)
        headers.set("X-Goog-FieldMask",
                "places.displayName,places.formattedAddress,places.location");

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<JsonNode> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                JsonNode.class
        );

        JsonNode body = response.getBody();

        if (body == null || body.path("places").isEmpty()) {
            throw new RuntimeException("Nenhum restaurante encontrado");
        }

        JsonNode place = body.path("places").get(0);

        String nome = place.path("displayName").path("text").asText();
        String endereco = place.path("formattedAddress").asText();
//        double latitude = place.path("location").path("latitude").asText();
        double longitude = place.path("location").path("longitude").asDouble();

        RestauranteEntity restauranteEntity = new RestauranteEntity();
        restauranteEntity.setNome(nome);
//        restauranteEntity.setEndereco(new Endereco(endereco));
        restauranteEntity.setLongitude(String.valueOf(longitude));

        return restauranteEntity;
    }
}
