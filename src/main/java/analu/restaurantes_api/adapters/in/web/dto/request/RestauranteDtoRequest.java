package analu.restaurantes_api.adapters.in.web.dto.request;

import analu.restaurantes_api.application.model.Endereco;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteDtoRequest {

    @NotNull
    private String nome;
    @NotNull
    private Endereco endereco;
}
