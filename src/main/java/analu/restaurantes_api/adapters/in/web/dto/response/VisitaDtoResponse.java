package analu.restaurantes_api.adapters.in.web.dto.response;

import analu.restaurantes_api.adapters.out.persistence.entity.VisitaEntity;
import analu.restaurantes_api.application.model.Endereco;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
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
