package analu.restaurantes_api.adapters.out.persistence.entity;

import analu.restaurantes_api.application.model.Endereco;
import analu.restaurantes_api.application.model.Visita;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document(collection = "restaurantes_table")
public class RestauranteEntity {

    @Id
    private String id;
    private String nome;
    private Endereco endereco;
    private Boolean jaVisitou;
    private List<VisitaEntity> visitas = new ArrayList<>();
    private String latitude;
    private String longitude;

}