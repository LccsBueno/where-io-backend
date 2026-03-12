package analu.restaurantes_api.adapters.out.persistence.repository;

import analu.restaurantes_api.adapters.out.persistence.entity.RestauranteEntity;
import analu.restaurantes_api.application.ports.out.RestauranteRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RestauranteRepositoryAdapter implements RestauranteRepositoryPort {

    @Autowired
    SprintDataRepository repository;

    @Override
    public RestauranteEntity save(RestauranteEntity restauranteEntity) {
        return repository.save(restauranteEntity);
    }

    @Override
    public RestauranteEntity findByNome(String nome) {
        return repository.findByNome(nome);
    }

    @Override
    public List<RestauranteEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public RestauranteEntity findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public RestauranteEntity atualizarRestaurante(RestauranteEntity restauranteEntity, String id) {
        return repository.findById(id)
                .map(restaurante -> {
                    restaurante.setNome(restauranteEntity.getNome());
                    restaurante.setEndereco(restauranteEntity.getEndereco());
                    restaurante.setLatitude(restauranteEntity.getLatitude());
                    restaurante.setLongitude(restauranteEntity.getLongitude());
                    return repository.save(restaurante);
                })
                .orElse(null);
    }


}
