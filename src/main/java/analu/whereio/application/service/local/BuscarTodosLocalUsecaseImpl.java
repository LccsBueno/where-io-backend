package analu.whereio.application.service.local;

import analu.whereio.application.model.Local;
import analu.whereio.application.ports.in.local.BuscarTodosLocalUsecase;
import analu.whereio.application.ports.out.LocalRepositoryPort;
import analu.whereio.application.ports.out.VisitaRepositoryPort;
import analu.whereio.exceptions.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarTodosLocalUsecaseImpl implements BuscarTodosLocalUsecase {

    private final LocalRepositoryPort localRepositoryPort;
    private final VisitaRepositoryPort visitaRepository;

    @Override
    public List<Local> execute() {

        try{
            List<Local> lista = localRepositoryPort
                    .buscarTodosLocal()
                    .stream()
                    .map(local ->{
                        local.setVisitas(visitaRepository.buscarVisitasPorIdLocal(local.getId()));
                        return local;
                    })
                    .toList();

            return lista;

        }catch (Exception e){
            throw new BusinessException("Ocorreu um erro ao buscar os locais", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
