package analu.restaurantes_api.adapters.out.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Getter
@Setter
public class VisitaEntity {

    @Id
    private ObjectId id = new ObjectId();
    private LocalDate dataVisita;
    private int avaliacao;
    private String comentario;

}
