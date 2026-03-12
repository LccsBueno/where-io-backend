package analu.restaurantes_api.application.service.visita;

import analu.restaurantes_api.adapters.out.persistence.entity.VisitaEntity;
import analu.restaurantes_api.application.ports.in.VisitaServicePort;
import analu.restaurantes_api.application.ports.out.RestauranteRepositoryPort;
import analu.restaurantes_api.application.ports.out.VisitaRepositoryPort;
import analu.restaurantes_api.exceptions.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class VisitaService implements VisitaServicePort {

    @Autowired
    private final VisitaRepositoryPort visitaRepositoryPort;

    @Autowired
    private final RestauranteRepositoryPort restauranteRepositoryPort;

    @Override
    public VisitaEntity adicionarVisita(VisitaEntity visitaEntity, String id) {

        if(isNull(restauranteRepositoryPort.findById(id))){;
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
