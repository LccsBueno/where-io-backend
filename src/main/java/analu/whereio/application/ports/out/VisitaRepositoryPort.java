package analu.whereio.application.ports.out;

import analu.whereio.adapters.out.persistence.entity.VisitaEntity;

public interface VisitaRepositoryPort {

    VisitaEntity adicionarVisita(VisitaEntity visitaEntity, String id);
    void removerVisita(String id);
    VisitaEntity atualizarVisita(VisitaEntity visitaEntity, String id);
}
