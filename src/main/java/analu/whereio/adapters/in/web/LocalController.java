package analu.whereio.adapters.in.web;

import analu.whereio.adapters.in.web.dto.request.LocalDtoRequest;
import analu.whereio.adapters.in.web.dto.response.LocalDtoResponse;
import analu.whereio.adapters.out.persistence.entity.LocalEntity;
import analu.whereio.adapters.out.persistence.mapper.LocalPersistenceMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurantes")
public class LocalController {

    private final RestauranteServicePort restauranteServicePort;
    private final LocalPersistenceMapper localPersistenceMapper;

    @PostMapping
    ResponseEntity<String> addRestaurante(@Valid @RequestBody LocalDtoRequest localDtoRequest) {

        LocalEntity localEntity = restauranteServicePort.adicionarRestaurante(localPersistenceMapper.requestToEntity(localDtoRequest));
        return ResponseEntity.ok(localEntity.getId());
    }

    @GetMapping("/buscar/{input}")
    ResponseEntity<List<LocalDtoResponse>> buscarRestaurante(@PathVariable String input) {
        List<LocalDtoResponse> listaRestauranteEntity = restauranteServicePort
                .buscarRestaurante(input)
                .stream()
                .map(localPersistenceMapper::entityToResponse)
                .toList();

        return ResponseEntity.ok(listaRestauranteEntity);

    }

    @GetMapping("/all")
    ResponseEntity<List<LocalDtoResponse>> getAllRestaurante() {

        List<LocalDtoResponse> listaRestauranteEntity = restauranteServicePort
                .getAllRestaurante()
                .stream()
                .map(localPersistenceMapper::entityToResponse)
                .toList();

        return ResponseEntity.ok(listaRestauranteEntity);
    }

    @PutMapping("/{id}")
    ResponseEntity<LocalDtoResponse> updateRestaurante(@PathVariable String id, @Valid @RequestBody LocalDtoRequest localDtoRequest) {

        LocalEntity localEntity = restauranteServicePort.atualizarRestaurante(localPersistenceMapper.requestToEntity(localDtoRequest), id);
        return ResponseEntity.ok(localPersistenceMapper.entityToResponse(localEntity));
    }
}
