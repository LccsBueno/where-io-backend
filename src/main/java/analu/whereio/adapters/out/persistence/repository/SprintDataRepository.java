package analu.whereio.adapters.out.persistence.repository;

import analu.whereio.adapters.out.persistence.entity.LocalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SprintDataRepository extends MongoRepository<LocalEntity, String> {

    LocalEntity findByNome(String nome);
}
