package analu.restaurantes_api.adapters.out.persistence.mapper;

import analu.restaurantes_api.adapters.in.web.dto.request.RestauranteDtoRequest;
import analu.restaurantes_api.adapters.in.web.dto.response.RestauranteDtoResponse;
import analu.restaurantes_api.adapters.out.persistence.entity.RestauranteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RestauranteMapper {

     RestauranteEntity requestToEntity(RestauranteDtoRequest restauranteDtoRequest);

//     @Mapping(target = "id", ignore = true)
//     @Mapping(target = "jaVisitou", ignore = true)
//     @Mapping(target = "visitas", ignore = true)
//     @Mapping(target = "latitude", ignore = true)
//     @Mapping(target = "longitude", ignore = true)
     RestauranteDtoResponse entityToResponse(RestauranteEntity restauranteEntity);

}