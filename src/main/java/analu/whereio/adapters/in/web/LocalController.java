package analu.whereio.adapters.in.web;

import analu.whereio.adapters.in.web.converter.LocalConverter;
import analu.whereio.adapters.in.web.dto.request.LocalDtoRequest;
import analu.whereio.adapters.in.web.dto.response.LocalDtoResponse;
import analu.whereio.application.ports.in.local.AtualizarLocalUsecase;
import analu.whereio.application.ports.in.local.BuscarLocalUsecase;
import analu.whereio.application.ports.in.local.BuscarTodosLocalUsecase;
import analu.whereio.application.ports.in.local.CadastrarLocalUsecase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/local")
public class LocalController {

    private final CadastrarLocalUsecase cadastrarLocalUsecase;
    private final AtualizarLocalUsecase atualizarLocalUsecase;
    private final BuscarLocalUsecase buscarLocalUsecase;
    private final BuscarTodosLocalUsecase buscarTodosLocalUsecase;

    private final LocalConverter mapper;

    @PostMapping
    ResponseEntity<String> cadastrarLocal(@Valid @RequestBody LocalDtoRequest localDtoRequest) {

        LocalDtoResponse localDtoResponse = mapper.toResponse(cadastrarLocalUsecase.execute(mapper.toDomain(localDtoRequest)));
        return ResponseEntity.status(HttpStatus.OK).body(localDtoResponse.getId());
    }

    @GetMapping("/buscar/{input}")
    ResponseEntity<List<LocalDtoResponse>> buscarLocal(@PathVariable String input) {
        List<LocalDtoResponse> listaLocalDtoResponse = buscarLocalUsecase
                .execute(input)
                .stream()
                .map(mapper::toResponse)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(listaLocalDtoResponse);
    }

    @GetMapping("/all")
    ResponseEntity<List<LocalDtoResponse>> buscarTodosLocais() {

        List<LocalDtoResponse> listaLocalDtoResponse = buscarTodosLocalUsecase
                .execute()
                .stream()
                .map(mapper::toResponse)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(listaLocalDtoResponse);
    }

    @PutMapping("/{id}")
    ResponseEntity<LocalDtoResponse> atualizarLocal(@PathVariable String id, @Valid @RequestBody LocalDtoRequest localDtoRequest) {

        atualizarLocalUsecase.execute(mapper.toDomain(localDtoRequest), id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
