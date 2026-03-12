package analu.restaurantes_api.adapters.in.web;

import analu.restaurantes_api.adapters.in.web.dto.request.RestauranteDtoRequest;
import analu.restaurantes_api.adapters.in.web.dto.response.RestauranteDtoResponse;
import analu.restaurantes_api.adapters.out.persistence.entity.RestauranteEntity;
import analu.restaurantes_api.adapters.out.persistence.mapper.RestauranteMapper;
import analu.restaurantes_api.application.ports.in.RestauranteServicePort;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurantes")
public class RestauranteController {

    @Autowired
    private final RestauranteServicePort restauranteServicePort;

    @Autowired
    private final RestauranteMapper restauranteMapper;

    @PostMapping
    ResponseEntity<String> addRestaurante(@Valid @RequestBody RestauranteDtoRequest restauranteDtoRequest) {

        RestauranteEntity restauranteEntity = restauranteServicePort.adicionarRestaurante(restauranteMapper.requestToEntity(restauranteDtoRequest));
        return ResponseEntity.ok(restauranteEntity.getId());
    }

    @GetMapping("/buscar/{input}")
    ResponseEntity<List<RestauranteDtoResponse>> buscarRestaurante(@PathVariable String input) {
        List<RestauranteDtoResponse> listaRestauranteEntity = restauranteServicePort
                .buscarRestaurante(input)
                .stream()
                .map(restauranteMapper::entityToResponse)
                .toList();

        return ResponseEntity.ok(listaRestauranteEntity);

    }

    @GetMapping("/all")
    ResponseEntity<List<RestauranteDtoResponse>> getAllRestaurante() {

        List<RestauranteDtoResponse> listaRestauranteEntity = restauranteServicePort
                .getAllRestaurante()
                .stream()
                .map(restauranteMapper::entityToResponse)
                .toList();

        return ResponseEntity.ok(listaRestauranteEntity);
    }

    @PutMapping("/{id}")
    ResponseEntity<RestauranteDtoResponse> updateRestaurante(@PathVariable String id, @Valid @RequestBody RestauranteDtoRequest restauranteDtoRequest) {

        RestauranteEntity restauranteEntity = restauranteServicePort.atualizarRestaurante(restauranteMapper.requestToEntity(restauranteDtoRequest), id);
        return ResponseEntity.ok(restauranteMapper.entityToResponse(restauranteEntity));
    }
}
