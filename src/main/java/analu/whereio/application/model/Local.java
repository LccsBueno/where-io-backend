package analu.whereio.application.model;

import analu.whereio.adapters.out.persistence.entity.VisitaEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Local {

    private String id;
    private String nome;
    private Endereco endereco;
    private Boolean jaVisitou;
    private List<VisitaEntity> visitas = new ArrayList<>();
    private String latitude;
    private String longitude;
}
