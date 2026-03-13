package analu.whereio.application.ports.in.local;

import analu.whereio.adapters.out.persistence.entity.LocalEntity;
import analu.whereio.application.model.Local;

public interface AdicionarLocalUsecase {

    LocalEntity adicionarLocal(Local local);
}
