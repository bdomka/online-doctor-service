package pl.zajavka.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import pl.zajavka.domain.Doctor;
import pl.zajavka.domain.Visit;
import pl.zajavka.infrastructure.database.entity.DoctorEntity;
import pl.zajavka.infrastructure.database.entity.VisitEntity;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DoctorEntityMapper {

    @Mapping(source = "visits", target = "visits", qualifiedByName = "mapVisits")
    Doctor mapFromEntity (DoctorEntity doctorEntity);

    @Named("mapVisits")
    @SuppressWarnings("unused")
    default Set<Visit> mapVisits (Set<VisitEntity> visitEntities) {
        return visitEntities.stream().map(visitEntity -> mapFromEntity(visitEntity)).collect(Collectors.toSet());
    }

    @Mapping(target = "patient", ignore = true)
    @Mapping(target = "doctor", ignore = true)
    @Mapping(target = "visitNote", ignore = true)
    Visit mapFromEntity(VisitEntity visitEntity);

    DoctorEntity mapToEntity (Doctor doctor);
}
