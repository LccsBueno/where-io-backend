package analu.restaurantes_api.application.ports.in;

import analu.restaurantes_api.adapters.in.web.dto.request.RestauranteDtoRequest;
import analu.restaurantes_api.adapters.in.web.dto.response.RestauranteDtoResponse;
import analu.restaurantes_api.adapters.out.persistence.entity.RestauranteEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RestauranteServicePort {

    RestauranteEntity adicionarRestaurante(RestauranteEntity restauranteDtoRequest);

    List<RestauranteEntity> getAllRestaurante();

    RestauranteEntity atualizarRestaurante(RestauranteEntity restauranteDtoRequest, String id);

    List<RestauranteEntity> buscarRestaurante(String input);

}
