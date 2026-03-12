package analu.restaurantes_api.application.ports.out;

import analu.restaurantes_api.adapters.out.persistence.entity.VisitaEntity;
import analu.restaurantes_api.application.model.Visita;

public interface VisitaRepositoryPort {

    VisitaEntity adicionarVisita(VisitaEntity visitaEntity, String id);
    void removerVisita(String id);
    VisitaEntity atualizarVisita(VisitaEntity visitaEntity, String id);
}
