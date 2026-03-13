package analu.whereio.adapters.in.web.dto.request;

import analu.whereio.application.model.Endereco;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalDtoRequest {

    @NotNull
    private String nome;
    @NotNull
    private Endereco endereco;
}
