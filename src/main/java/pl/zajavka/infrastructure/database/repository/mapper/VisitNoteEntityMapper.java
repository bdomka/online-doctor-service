package pl.zajavka.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.zajavka.domain.Visit;
import pl.zajavka.domain.VisitNote;
import pl.zajavka.infrastructure.database.entity.VisitEntity;
import pl.zajavka.infrastructure.database.entity.VisitNoteEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VisitNoteEntityMapper {

    @Mapping(target = "visit", ignore = true)
    VisitNote mapFromEntity(VisitNoteEntity visitNoteEntity);

    @Mapping(target = "visit", ignore = true)
    VisitNote mapToEntity(VisitNoteEntity visitNoteEntity);
}
