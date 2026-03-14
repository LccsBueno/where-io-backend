package analu.whereio.application.service.visita;

import analu.whereio.application.model.Visita;
import analu.whereio.application.ports.in.visita.CadastrarVisitaUsecase;
import analu.whereio.application.ports.out.LocalRepositoryPort;
import analu.whereio.application.ports.out.VisitaRepositoryPort;
import analu.whereio.exceptions.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class CadastrarVisitaUsecaseImpl implements CadastrarVisitaUsecase {

    private final LocalRepositoryPort localRepositoryPort;
    private final VisitaRepositoryPort visitaRepositoryPort;

    @Override
    public String execute(Visita visita, String idLocal) {

        if(isNull(localRepositoryPort.buscarPorIdLocal(idLocal))){;
            throw new BusinessException("Não existe restaurante com esse id", HttpStatus.NOT_FOUND);
        }

        return visitaRepositoryPort.adicionarVisita(visita, idLocal);
    }
}
