package analu.restaurantes_api.application.ports.in;

import analu.restaurantes_api.adapters.out.persistence.entity.VisitaEntity;
import analu.restaurantes_api.application.model.Visita;

public interface VisitaServicePort {

    VisitaEntity adicionarVisita(VisitaEntity visitaEntity, String id);
    void removerVisita(String id);
    VisitaEntity atualizarVisita(VisitaEntity visitaEntity, String id);
}
