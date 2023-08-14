package pl.zajavka.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.zajavka.domain.Doctor;
import pl.zajavka.domain.MedicalHistory;
import pl.zajavka.infrastructure.database.entity.DoctorEntity;
import pl.zajavka.infrastructure.database.entity.MedicalHistoryEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicalHistoryEntityMapper {

    MedicalHistoryEntity mapToEntity (MedicalHistory medicalHistory);

    MedicalHistory mapFromEntity (MedicalHistoryEntity medicalHistoryEntity);

}
