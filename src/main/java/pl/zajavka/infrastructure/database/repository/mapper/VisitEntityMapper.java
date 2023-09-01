package pl.zajavka.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.zajavka.domain.Visit;
import pl.zajavka.domain.VisitNote;
import pl.zajavka.infrastructure.database.entity.VisitEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VisitEntityMapper {


    @Mapping(target = "visitNote", ignore = true)
    Visit mapFromEntity(VisitEntity visitEntity);

//    default Visit mapFromEntityWithVisitNote(VisitEntity visitEntity) {
//        return mapFromEntity(visitEntity)
//                .withVisitNote(VisitNote.builder()
//                        .visitNoteNumber(visitEntity.getVisitNote().getVisitNoteNumber())
//                        .build());
//    }

    VisitEntity mapToEntity(Visit visit);
}
