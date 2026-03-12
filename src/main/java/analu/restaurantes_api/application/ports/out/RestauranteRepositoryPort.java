package analu.restaurantes_api.application.ports.out;

import analu.restaurantes_api.adapters.out.persistence.entity.RestauranteEntity;

import java.util.List;

public interface RestauranteRepositoryPort {

        RestauranteEntity save(RestauranteEntity restauranteEntity);

        RestauranteEntity findByNome(String nome);

        List<RestauranteEntity> findAll();

        RestauranteEntity findById(String id);

        RestauranteEntity atualizarRestaurante(RestauranteEntity restauranteEntity, String id);


}
