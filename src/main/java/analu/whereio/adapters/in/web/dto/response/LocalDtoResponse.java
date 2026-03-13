package analu.whereio.adapters.in.web.dto.response;

import analu.whereio.adapters.out.persistence.entity.VisitaEntity;
import analu.whereio.application.model.Endereco;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@JsonPropertyOrder({"id", "nome", "endereco", "latitude", "longitude"})
public class LocalDtoResponse {

    @Id
    private String id;
    private String nome;
    private Endereco endereco;
    private Boolean jaVisitou;
    private List<VisitaEntity> visitas = new ArrayList<>();
    private String latitude;
    private String longitude;
}
