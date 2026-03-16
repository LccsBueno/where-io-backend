package analu.whereio.adapters.out.persistence.repository;

import analu.whereio.adapters.out.persistence.entity.VisitaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VisitaRepository extends MongoRepository<VisitaEntity, String> {

    List<VisitaEntity> findByIdLocal(String idLocal);
}
