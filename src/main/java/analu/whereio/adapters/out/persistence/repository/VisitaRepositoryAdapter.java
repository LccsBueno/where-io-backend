package analu.whereio.adapters.out.persistence.repository;

import analu.whereio.adapters.out.persistence.mapper.VisitaPersistanceMapper;
import analu.whereio.application.model.Visita;
import analu.whereio.application.ports.out.VisitaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VisitaRepositoryAdapter implements VisitaRepositoryPort {

    private final SprintDataRepository repository;
    private final VisitaPersistanceMapper mapper;

    @Override
    public String adicionarVisita(Visita visita, String idLocal) {

        return repository
                .findById(idLocal)
                .map(restaurante -> {
                    restaurante.getVisitas().add(mapper.toEntity(visita));
                    return repository.save(restaurante);
                })
                .get().getId();
    }

    @Override
    public void removerVisita(String id) {

    }

    @Override
    public Visita atualizarVisita(Visita visita, String idVisita) {
        return null;
    }
}
