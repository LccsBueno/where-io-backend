package analu.whereio.application.service.visita;

import analu.whereio.application.ports.in.visita.RemoverVisitaUsecase;
import analu.whereio.application.ports.out.VisitaRepositoryPort;
import analu.whereio.exceptions.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemoverVisitaUsecaseImpl implements RemoverVisitaUsecase {

    private final VisitaRepositoryPort visitaRepositoryPort;

    @Override
    public void execute(String id) {

        try{
            visitaRepositoryPort.removerVisita(id);

        }catch (Exception e){
            throw new BusinessException("Erro ao remover visita: ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
