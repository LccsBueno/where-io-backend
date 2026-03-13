package analu.whereio.adapters.in.web.dto.response;

import analu.whereio.adapters.out.persistence.entity.VisitaEntity;
import analu.whereio.application.model.Endereco;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VisitaDtoResponse {

    private String id;
    private String nome;
    private Endereco endereco;
    private Boolean jaVisitou;
    private List<VisitaEntity> visitas;
    private String latitude;
    private String longitude;
}
