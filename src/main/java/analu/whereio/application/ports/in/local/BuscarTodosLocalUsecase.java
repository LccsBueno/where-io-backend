package analu.whereio.application.ports.in.local;

import analu.whereio.adapters.out.persistence.entity.LocalEntity;

import java.util.List;

public interface BuscarTodosLocalUsecase {

    List<LocalEntity> getAllLocal();
}
