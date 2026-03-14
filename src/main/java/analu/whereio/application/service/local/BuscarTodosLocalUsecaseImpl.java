package analu.whereio.application.service.local;

import analu.whereio.application.model.Local;
import analu.whereio.application.ports.in.local.BuscarTodosLocalUsecase;
import analu.whereio.application.ports.out.LocalRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BuscarTodosLocalUsecaseImpl implements BuscarTodosLocalUsecase {

    private final LocalRepositoryPort localRepositoryPort;

    @Override
    public List<Local> execute() {
                return localRepositoryPort.
                buscarTodosLocal()
                .stream()
                .toList();
    }
}
