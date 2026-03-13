package analu.whereio.adapters.out.persistence.repository;

import analu.whereio.adapters.out.persistence.entity.LocalEntity;
import analu.whereio.application.ports.out.RestauranteRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LocalRepositoryAdapter implements RestauranteRepositoryPort {

    @Autowired
    SprintDataRepository repository;

    @Override
    public LocalEntity cadastrarLocal(LocalEntity localEntity) {
        return repository.save(localEntity);
    }

    @Override
    public LocalEntity buscarPorNomeLocal(String nome) {
        return repository.findByNome(nome);
    }

    @Override
    public List<LocalEntity> buscarTodosLocal() {
        return repository.findAll();
    }

    @Override
    public LocalEntity buscarPorIdLocal(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public LocalEntity atualizarLocal(LocalEntity localEntity, String id) {
        return repository.findById(id)
                .map(restaurante -> {
                    restaurante.setNome(localEntity.getNome());
                    restaurante.setEndereco(localEntity.getEndereco());
                    restaurante.setLatitude(localEntity.getLatitude());
                    restaurante.setLongitude(localEntity.getLongitude());
                    return repository.save(restaurante);
                })
                .orElse(null);
    }


}
