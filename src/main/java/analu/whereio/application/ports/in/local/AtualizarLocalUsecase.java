package analu.whereio.application.ports.in.local;

import analu.whereio.adapters.out.persistence.entity.LocalEntity;

public interface AtualizarLocalUsecase {

    LocalEntity atualizarLocal(LocalEntity restauranteDtoRequest, String id);
}
