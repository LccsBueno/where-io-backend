package analu.restaurantes_api.adapters.out.persistence.repository;

import analu.restaurantes_api.adapters.out.persistence.entity.VisitaEntity;
import analu.restaurantes_api.application.model.Visita;
import analu.restaurantes_api.application.ports.out.RestauranteRepositoryPort;
import analu.restaurantes_api.application.ports.out.VisitaRepositoryPort;
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
