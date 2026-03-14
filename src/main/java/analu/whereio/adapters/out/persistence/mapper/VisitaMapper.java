package analu.whereio.adapters.out.persistence.mapper;

import analu.whereio.adapters.in.web.dto.request.VisitaDtoRequest;
import analu.whereio.adapters.out.persistence.entity.VisitaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VisitaMapper {

//    @Mapping(target = "id", ignore = true)
    VisitaEntity requestToEntity(VisitaDtoRequest visitaDtoRequest);
//    VisitaDtoResponse entityToResponse(VisitaEntity visitaEntity);
}
