package analu.whereio.application.ports.out;

import analu.whereio.adapters.out.persistence.entity.LocalEntity;

public interface GeocodingPort {

    LocalEntity buscarRestaurantePorEnderecoENome(String input);
}
