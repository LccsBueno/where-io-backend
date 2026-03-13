package analu.whereio.adapters.out.persistence.repository;

import analu.whereio.adapters.out.persistence.entity.VisitaEntity;
import analu.whereio.application.ports.out.VisitaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VisitaRepositoryAdapter implements VisitaRepositoryPort {

    @Autowired
    SprintDataRepository repository;

    @Override
    public VisitaEntity adicionarVisita(VisitaEntity visitaEntity, String id) {

        repository.findById(id)
                .map(restaurante -> {
                    restaurante.getVisitas().add(visitaEntity);
                    return repository.save(restaurante);
        });

        return visitaEntity;
    }

    @Override
    public void removerVisita(String id) {

    }

    @Override
    public VisitaEntity atualizarVisita(VisitaEntity visitaEntity, String id) {
        return null;
    }
}
