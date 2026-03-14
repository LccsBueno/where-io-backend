package analu.whereio.application.service.visita;

import analu.whereio.adapters.out.persistence.entity.VisitaEntity;
import analu.whereio.application.ports.in.VisitaServicePort;
import analu.whereio.application.ports.out.LocalRepositoryPort;
import analu.whereio.application.ports.out.VisitaRepositoryPort;
import analu.whereio.exceptions.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class VisitaService implements VisitaServicePort {

    @Autowired
    private final VisitaRepositoryPort visitaRepositoryPort;

    @Autowired
    private final LocalRepositoryPort localRepositoryPort;

    @Override
    public VisitaEntity adicionarVisita(VisitaEntity visitaEntity, String id) {

        if(isNull(localRepositoryPort.buscarPorIdLocal(id))){;
            throw new BusinessException("Não existe restaurante com esse id", HttpStatus.NOT_FOUND);
        }

        visitaRepositoryPort.adicionarVisita(visitaEntity, id);
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
