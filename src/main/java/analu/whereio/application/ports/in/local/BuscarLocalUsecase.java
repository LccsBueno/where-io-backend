package analu.whereio.application.ports.in.local;

import analu.whereio.application.model.Local;

import java.util.List;

public interface BuscarLocalUsecase {

    List<Local> execute(String input);

}
