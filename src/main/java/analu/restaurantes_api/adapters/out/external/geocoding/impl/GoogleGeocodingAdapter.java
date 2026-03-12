package analu.restaurantes_api.adapters.out.external.geocoding.impl;

import analu.restaurantes_api.adapters.out.external.geocoding.record.LatitudeLongitudeRecord;
import analu.restaurantes_api.application.ports.out.LatitudeLongitudeInterfacePort;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.cfgxml.internal.ConfigLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import tools.jackson.databind.JsonNode;
import java.io.InputStream;
import java.util.Properties;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class GoogleGeocodingAdapter implements LatitudeLongitudeInterfacePort{

    private final RestTemplate restTemplate;

    public LatitudeLongitudeRecord ConverterEnderecoParaCoordenadas(String endereco) throws IOException, InterruptedException {

        Properties props = new Properties();

        InputStream input = ConfigLoader.class
                .getClassLoader()
                .getResourceAsStream("application.properties");

        props.load(input);

        String apikey = props.getProperty("google.map.api.key");

        String uri = "https://maps.googleapis.com/maps/api/geocode/json";

        String finalUri = UriComponentsBuilder
                .fromUriString(uri)
                .queryParam("address", endereco)
                .queryParam("key", apikey)
                .toUriString();

        ResponseEntity<JsonNode> response =
                restTemplate.getForEntity(finalUri, JsonNode.class);

        JsonNode body = response.getBody();

        String jsonReponse = body
                .path("results")
                .get(0)
                .path("formatted_address")
                .asText();

        System.out.println(jsonReponse);

         String latitude = body
                .path("results")
                .get(0)
                .path("geometry")
                .path("location")
                .path("lat")
                .asText();

        String longitude = body
                .path("results")
                .get(0)
                .path("geometry")
                .path("location")
                .path("lng")
                .asText();

        return new LatitudeLongitudeRecord(longitude, longitude);
    }
}
