package analu.whereio.application.ports.out;

import analu.whereio.adapters.out.persistence.entity.LocalEntity;

import java.util.List;

public interface RestauranteRepositoryPort {

        LocalEntity save(LocalEntity localEntity);

        LocalEntity findByNome(String nome);

        List<LocalEntity> findAll();

        LocalEntity findById(String id);

        LocalEntity atualizarRestaurante(LocalEntity localEntity, String id);


}
