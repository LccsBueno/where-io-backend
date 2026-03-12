package analu.restaurantes_api.adapters.in.web;

import analu.restaurantes_api.adapters.in.web.dto.request.VisitaDtoRequest;
import analu.restaurantes_api.adapters.in.web.dto.response.VisitaDtoResponse;
import analu.restaurantes_api.adapters.out.persistence.entity.VisitaEntity;
import analu.restaurantes_api.adapters.out.persistence.mapper.VisitaMapper;
import analu.restaurantes_api.application.ports.in.VisitaServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/visita")
@RequiredArgsConstructor
public class VisitaController {

    @Autowired
    private final VisitaServicePort VisitaServicePort;

    @Autowired
    private final VisitaMapper visitaMapper;

    @PostMapping("/{id}")
    public ResponseEntity<VisitaDtoResponse> adicionarVisita(@PathVariable String id, @RequestBody VisitaDtoRequest visitaDtoRequest) {
        VisitaEntity teste = visitaMapper.requestToEntity(visitaDtoRequest);
        VisitaServicePort.adicionarVisita(teste, id);
        return ResponseEntity.status(201).build();
    }


}
