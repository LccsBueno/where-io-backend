package analu.whereio.adapters.in.web;

import analu.whereio.adapters.in.web.converter.VisitaConverter;
import analu.whereio.adapters.in.web.dto.request.VisitaDtoRequest;
import analu.whereio.adapters.in.web.dto.response.VisitaDtoResponse;
import analu.whereio.application.ports.in.visita.CadastrarVisitaUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/visita")
@RequiredArgsConstructor
public class VisitaController {

    private final CadastrarVisitaUsecase cadastrarVisitaUsecase;

    private final VisitaConverter mapper;

    @PostMapping("/{idLocal}")
    public ResponseEntity<VisitaDtoResponse> adicionarVisita(@PathVariable String idLocal, @RequestBody VisitaDtoRequest visitaDtoRequest) {

        cadastrarVisitaUsecase.execute(mapper.toDomain(visitaDtoRequest), idLocal);
        return ResponseEntity.status(201).build();
    }

}
