package analu.whereio.application.service.local;

import analu.whereio.application.model.Local;
import analu.whereio.application.ports.in.local.BuscarTodosLocalUsecase;
import analu.whereio.application.ports.out.LocalRepositoryPort;
import analu.whereio.exceptions.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarTodosLocalUsecaseImpl implements BuscarTodosLocalUsecase {

    private final LocalRepositoryPort localRepositoryPort;

    @Override
    public List<Local> execute() {

        try{
            return localRepositoryPort
                    .buscarTodosLocal()
                    .stream()
                    .toList();

        }catch (Exception e){
            throw new BusinessException("Ocorreu um erro ao buscar os locais", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
