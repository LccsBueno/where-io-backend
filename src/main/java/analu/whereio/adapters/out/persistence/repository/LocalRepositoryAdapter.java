package analu.whereio.adapters.out.persistence.repository;

import analu.whereio.adapters.out.persistence.entity.LocalEntity;
import analu.whereio.adapters.out.persistence.mapper.LocalPersistenceMapper;
import analu.whereio.application.model.Local;
import analu.whereio.application.ports.out.LocalRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LocalRepositoryAdapter implements LocalRepositoryPort {

    private final SprintDataRepository repository;
    private final LocalPersistenceMapper mapper;


    @Override
    public Local cadastrarLocal(Local local) {
        return mapper.toDomain(repository.save(mapper.toEntity(local)));
    }

    @Override
    public Local buscarPorNomeLocal(String nome) {
        return mapper.toDomain(repository.findByNome(nome));
    }

    @Override
    public List<Local> buscarTodosLocal() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Local buscarPorIdLocal(String id) {
        return mapper.toDomain(repository.findById(id).orElse(null));
    }

    @Override
    public void atualizarLocal(Local local, String id) {

        LocalEntity localEntity = mapper.toEntity(local);
        localEntity.setId(id);
        repository.save(localEntity);
    }


}
