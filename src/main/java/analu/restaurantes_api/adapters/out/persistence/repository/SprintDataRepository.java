package analu.restaurantes_api.adapters.out.persistence.repository;

import analu.restaurantes_api.adapters.out.persistence.entity.RestauranteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SprintDataRepository extends MongoRepository<RestauranteEntity, String> {

    RestauranteEntity findByNome(String nome);
}
