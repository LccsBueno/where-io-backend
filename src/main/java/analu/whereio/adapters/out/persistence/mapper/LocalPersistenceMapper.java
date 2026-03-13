package analu.whereio.adapters.out.persistence.mapper;

import analu.whereio.adapters.in.web.dto.request.LocalDtoRequest;
import analu.whereio.adapters.in.web.dto.response.LocalDtoResponse;
import analu.whereio.adapters.out.persistence.entity.LocalEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocalPersistenceMapper {

     LocalEntity requestToEntity(LocalDtoRequest localDtoRequest);

//     @Mapping(target = "id", ignore = true)
//     @Mapping(target = "jaVisitou", ignore = true)
//     @Mapping(target = "visitas", ignore = true)
//     @Mapping(target = "latitude", ignore = true)
//     @Mapping(target = "longitude", ignore = true)
     LocalDtoResponse entityToResponse(LocalEntity localEntity);

}