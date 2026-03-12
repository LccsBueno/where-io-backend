package analu.restaurantes_api.application.ports.out;

import analu.restaurantes_api.adapters.out.persistence.entity.RestauranteEntity;

public interface GeocodingPort {

    RestauranteEntity buscarRestaurantePorEnderecoENome(String input);
}
