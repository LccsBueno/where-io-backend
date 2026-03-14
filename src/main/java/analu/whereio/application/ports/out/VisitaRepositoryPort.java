package analu.whereio.application.ports.out;

import analu.whereio.application.model.Visita;

public interface VisitaRepositoryPort {

    String adicionarVisita(Visita visita, String idLocal);
    void removerVisita(String id);
    Visita atualizarVisita(Visita visita, String idVisita);
}
