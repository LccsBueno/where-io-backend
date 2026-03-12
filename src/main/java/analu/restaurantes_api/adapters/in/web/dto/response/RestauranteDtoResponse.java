package analu.restaurantes_api.adapters.in.web.dto.response;

import analu.restaurantes_api.adapters.out.persistence.entity.VisitaEntity;
import analu.restaurantes_api.application.model.Endereco;
import analu.restaurantes_api.application.model.Visita;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@JsonPropertyOrder({"id", "nome", "endereco", "latitude", "longitude"})
public class RestauranteDtoResponse {

    @Id
    private String id;
    private String nome;
    private Endereco endereco;
    private Boolean jaVisitou;
    private List<VisitaEntity> visitas = new ArrayList<>();
    private String latitude;
    private String longitude;
}
