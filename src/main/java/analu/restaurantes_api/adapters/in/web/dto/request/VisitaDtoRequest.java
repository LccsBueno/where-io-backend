package analu.restaurantes_api.adapters.in.web.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Getter
@Setter
public class VisitaDtoRequest {

    private LocalDate dataVisita;
    private int avaliacao;
    private String comentario;
}
