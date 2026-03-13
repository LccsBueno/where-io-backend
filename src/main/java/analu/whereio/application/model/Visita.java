package analu.whereio.application.model;

import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
public class Visita {

    private String id;
    private LocalDate dataVisita;
    private int avaliacao;
    private String comentario;

}
