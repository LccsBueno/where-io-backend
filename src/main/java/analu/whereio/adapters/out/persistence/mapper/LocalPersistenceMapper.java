package analu.whereio.adapters.out.persistence.mapper;

import analu.whereio.adapters.out.persistence.entity.LocalEntity;
import analu.whereio.application.model.Local;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocalPersistenceMapper {

     Local toDomain(LocalEntity localEntity);
     LocalEntity toEntity(Local local);

}