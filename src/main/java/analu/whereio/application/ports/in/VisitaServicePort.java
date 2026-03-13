package analu.whereio.application.ports.in;

import analu.whereio.adapters.out.persistence.entity.VisitaEntity;

public interface VisitaServicePort {

    VisitaEntity adicionarVisita(VisitaEntity visitaEntity, String id);
    void removerVisita(String id);
    VisitaEntity atualizarVisita(VisitaEntity visitaEntity, String id);
}
