package analu.whereio.application.service.visita;

import analu.whereio.application.model.Visita;
import analu.whereio.application.ports.in.visita.AtualizarVisitaUsecase;
import analu.whereio.application.ports.out.VisitaRepositoryPort;
import analu.whereio.exceptions.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class AtualizarVisitaUsecaseImpl implements AtualizarVisitaUsecase {

    private final VisitaRepositoryPort visitaRepositoryPort;

    @Override
    public void execute(String idVisita, Visita visita) {

        if(isNull(visitaRepositoryPort.buscarPorId(idVisita))){
            throw new BusinessException("Visita não encontrada", HttpStatus.NOT_FOUND);
        }

        try{
            visita.setId(idVisita);
            visitaRepositoryPort.atualizarVisita(visita);

        }catch (Exception e){
            throw new BusinessException("Ocorreu um erro ao atualizar a visita", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
