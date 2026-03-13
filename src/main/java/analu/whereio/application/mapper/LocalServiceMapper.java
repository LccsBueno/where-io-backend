package analu.whereio.application.mapper;

import analu.whereio.adapters.out.persistence.entity.LocalEntity;
import analu.whereio.application.model.Local;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocalServiceMapper {

    LocalEntity toEntity(Local local);
    Local toModel(LocalEntity localEntity);
}
