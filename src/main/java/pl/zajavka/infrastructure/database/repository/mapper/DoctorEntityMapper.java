package pl.zajavka.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.zajavka.domain.Doctor;
import pl.zajavka.infrastructure.database.entity.DoctorEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DoctorEntityMapper {

    @Mapping(target = "visit", ignore = true)
    Doctor mapFromEntity (DoctorEntity doctorEntity);

    @Mapping(target = "visit", ignore = true)
    DoctorEntity mapToEntity (Doctor doctor);
}
