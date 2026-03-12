package analu.restaurantes_api.adapters.out.persistence.mapper;

import analu.restaurantes_api.adapters.in.web.dto.request.VisitaDtoRequest;
import analu.restaurantes_api.adapters.out.persistence.entity.VisitaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VisitaMapper {

//    @Mapping(target = "id", ignore = true)
    VisitaEntity requestToEntity(VisitaDtoRequest visitaDtoRequest);
//    VisitaDtoResponse entityToResponse(VisitaEntity visitaEntity);
}
