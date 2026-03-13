package analu.whereio.adapters.out.persistence.mapper;

import analu.whereio.adapters.in.web.dto.request.VisitaDtoRequest;
import analu.whereio.adapters.out.persistence.entity.VisitaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitaMapper {

//    @Mapping(target = "id", ignore = true)
    VisitaEntity requestToEntity(VisitaDtoRequest visitaDtoRequest);
//    VisitaDtoResponse entityToResponse(VisitaEntity visitaEntity);
}
