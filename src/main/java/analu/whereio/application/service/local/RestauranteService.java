//package analu.whereio.application.service.local;
//
//import analu.whereio.adapters.out.persistence.entity.LocalEntity;
//import analu.whereio.adapters.out.external.geocoding.record.LatitudeLongitudeRecord;
//import analu.whereio.application.ports.out.GeocodingPort;
//import analu.whereio.application.ports.out.LatitudeLongitudeInterfacePort;
//import analu.whereio.application.ports.out.LocalRepositoryPort;
//import analu.whereio.exceptions.BusinessException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.List;
//
//import static java.util.Objects.isNull;
//
//@Service
//@RequiredArgsConstructor
//public class RestauranteService {
//
//    @Autowired
//    LocalRepositoryPort restaurantesRepositoryPort;
//
//    @Autowired
//    private final LatitudeLongitudeInterfacePort latitudeLongitudePort;
//
//    private final GeocodingPort geocodingPort;
//
//
//    @Override
//    public List<LocalEntity> getAllRestaurante() {
//        return restaurantesRepositoryPort.
//                findAll()
//                .stream()
//                .toList();
//    }
//
//    @Override
//    public LocalEntity atualizarRestaurante(LocalEntity localEntity, String id) {
//
//        if(isNull(restaurantesRepositoryPort.findById(id))){
//            throw new BusinessException("ID de Restaurante não existe", HttpStatus.NOT_FOUND);
//        }
//
//        localEntity.setId(id);
//
//        try{
//            LatitudeLongitudeRecord record = latitudeLongitudePort.ConverterEnderecoParaCoordenadas(localEntity.getEndereco().toString());
//            localEntity.setLatitude(record.latitude());
//            localEntity.setLongitude(record.longitude());
//
//        } catch (RuntimeException | IOException | InterruptedException e) {
//            throw new BusinessException("Restaurante não foi encontrado", HttpStatus.NOT_FOUND);
//        }
//
//        restaurantesRepositoryPort.save(localEntity);
//
//        return localEntity;
//    }
//
//    @Override
//    public List<LocalEntity> buscarRestaurante(String input) {
//        LocalEntity Teste = geocodingPort.buscarRestaurantePorEnderecoENome(input);
//
//        List<LocalEntity> mock = List.of();
//        return mock;
//    }
//}
