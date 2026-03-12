package analu.restaurantes_api.application.service.restaurante;

import analu.restaurantes_api.adapters.in.web.dto.request.RestauranteDtoRequest;
import analu.restaurantes_api.adapters.in.web.dto.response.RestauranteDtoResponse;
import analu.restaurantes_api.adapters.out.persistence.mapper.RestauranteMapper;
import analu.restaurantes_api.adapters.out.persistence.repository.RestauranteRepositoryAdapter;
import analu.restaurantes_api.adapters.out.persistence.entity.RestauranteEntity;
import analu.restaurantes_api.adapters.out.external.geocoding.record.LatitudeLongitudeRecord;
import analu.restaurantes_api.application.ports.in.RestauranteServicePort;
import analu.restaurantes_api.application.ports.out.GeocodingPort;
import analu.restaurantes_api.application.ports.out.LatitudeLongitudeInterfacePort;
import analu.restaurantes_api.application.ports.out.RestauranteRepositoryPort;
import analu.restaurantes_api.exceptions.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class RestauranteService implements RestauranteServicePort {

    @Autowired
    RestauranteRepositoryPort restaurantesRepositoryPort;

    @Autowired
    private final LatitudeLongitudeInterfacePort latitudeLongitudePort;

    private final GeocodingPort geocodingPort;

    @Override
    public RestauranteEntity adicionarRestaurante(RestauranteEntity restauranteEntity) {

        if(!isNull(restaurantesRepositoryPort.findByNome(restauranteEntity.getNome()))){
            throw new BusinessException("Restaurante já cadastrado", HttpStatus.UNPROCESSABLE_CONTENT);
        }

        restauranteEntity.setJaVisitou(false);

        try{
            LatitudeLongitudeRecord record = latitudeLongitudePort.ConverterEnderecoParaCoordenadas(restauranteEntity.getEndereco().toString());
            restauranteEntity.setLatitude(record.latitude());
            restauranteEntity.setLongitude(record.longitude());

        } catch (RuntimeException | IOException | InterruptedException e) {
            throw new BusinessException("Restaurante não foi encontrado", HttpStatus.NOT_FOUND);
        }

        return restaurantesRepositoryPort.save(restauranteEntity);
    }

    @Override
    public List<RestauranteEntity> getAllRestaurante() {
        return restaurantesRepositoryPort.
                findAll()
                .stream()
                .toList();
    }

    @Override
    public RestauranteEntity atualizarRestaurante(RestauranteEntity restauranteEntity, String id) {

        if(isNull(restaurantesRepositoryPort.findById(id))){
            throw new BusinessException("ID de Restaurante não existe", HttpStatus.NOT_FOUND);
        }

        restauranteEntity.setId(id);

        try{
            LatitudeLongitudeRecord record = latitudeLongitudePort.ConverterEnderecoParaCoordenadas(restauranteEntity.getEndereco().toString());
            restauranteEntity.setLatitude(record.latitude());
            restauranteEntity.setLongitude(record.longitude());

        } catch (RuntimeException | IOException | InterruptedException e) {
            throw new BusinessException("Restaurante não foi encontrado", HttpStatus.NOT_FOUND);
        }

        restaurantesRepositoryPort.save(restauranteEntity);

        return restauranteEntity;
    }

    @Override
    public List<RestauranteEntity> buscarRestaurante(String input) {
        RestauranteEntity Teste = geocodingPort.buscarRestaurantePorEnderecoENome(input);

        List<RestauranteEntity> mock = List.of();
        return mock;
    }
}
