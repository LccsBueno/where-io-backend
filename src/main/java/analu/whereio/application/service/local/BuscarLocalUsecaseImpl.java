package analu.whereio.application.service.local;

import analu.whereio.application.model.Local;
import analu.whereio.application.ports.in.local.BuscarLocalUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor

public class BuscarLocalUsecaseImpl implements BuscarLocalUsecase {
    @Override
    public List<Local> execute(String input) {
        return List.of();
    }
}
