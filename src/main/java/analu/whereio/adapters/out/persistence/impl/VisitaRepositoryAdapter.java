package analu.whereio.adapters.out.persistence.impl;

import analu.whereio.adapters.out.persistence.mapper.VisitaPersistanceMapper;
import analu.whereio.adapters.out.persistence.repository.VisitaRepository;
import analu.whereio.application.model.Visita;
import analu.whereio.application.ports.out.VisitaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VisitaRepositoryAdapter implements VisitaRepositoryPort {

    private final VisitaRepository repository;
    private final VisitaPersistanceMapper mapper;

    @Override
    public String adicionarVisita(Visita visita) {

        return repository.save(mapper.toEntity(visita)).getId();
    }

    @Override
    public void removerVisita(String id) {
        repository.deleteById(id);
    }

    @Override
    public void atualizarVisita(Visita visita) {
        repository.save(mapper.toEntity(visita));
    }

    @Override
    public List<Visita> buscarVisitasPorIdLocal(String idLocal) {
        return repository
                .findByIdLocal(idLocal)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Visita buscarPorId(String id) {
        return repository.findById(id)
                .map(mapper::toDomain)
                .orElse(null);
    }
}
