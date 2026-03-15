package analu.whereio.application.service.local;

import analu.whereio.application.ports.in.local.RemoverLocalUsecase;
import analu.whereio.application.ports.out.LocalRepositoryPort;
import analu.whereio.exceptions.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemoverLocalUsecaseImpl implements RemoverLocalUsecase {

    private final LocalRepositoryPort localRepositoryPort;

    @Override
    public void execute(String id) {

        try{
            localRepositoryPort.removerLocalPorId(id);

        } catch (Exception e) {
            throw new BusinessException("Ocorreu um erro ao remover o local", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
