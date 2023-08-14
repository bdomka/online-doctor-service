package pl.zajavka.infrastructure.database.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import pl.zajavka.domain.MedicalHistory;
import pl.zajavka.domain.Patient;
import pl.zajavka.domain.Visit;
import pl.zajavka.infrastructure.database.entity.MedicalHistoryEntity;
import pl.zajavka.infrastructure.database.entity.PatientEntity;
import pl.zajavka.infrastructure.database.entity.VisitEntity;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PatientEntityMapper {
    @Mapping(source = "visits", target = "visits", qualifiedByName = "mapVisits") // tutaj taki zapis jak ma nie generować swojej tylko użyć mapVisits
    @Mapping(source = "medicalHistories", target = "medicalHistories", qualifiedByName = "mapMedicalHistories")
    Patient mapFromEntity(PatientEntity patientEntity);

   // default metode dajemy by nie generował swojej tylko wykorzystał tą
    // by uniknąć tej cyklicznej zależności że patient mapuje visit, a visit spowrotem patienta,  tak samo z doctor i visitNote
    //dlatego w mapFromEntity jest ignore do patirnt , doctor i visitNote
    // musi być Set bo mamy jako Set to okreslone wczesniej
    @Named("mapVisits")
    @SuppressWarnings("unused")
    default Set<Visit> mapVisits (Set<VisitEntity> visitEntities) {
        return visitEntities.stream().map(visitEntity -> mapFromEntity(visitEntity)).collect(Collectors.toSet());
    }

    @Named("mapMedicalHistories")
    @SuppressWarnings("unused")
    default Set<MedicalHistory> mapMedicalHistories (Set<MedicalHistoryEntity> medicalHistoryEntities) {
        return medicalHistoryEntities.stream().map(medicalHistoryEntity -> mapFromEntity(medicalHistoryEntity) ).collect(Collectors.toSet());
    }
    @Mapping(target = "patient", ignore = true)
    MedicalHistory mapFromEntity(MedicalHistoryEntity medicalHistoryEntity);
   @Mapping(target = "patient", ignore = true)
   @Mapping(target = "doctor", ignore = true)
   @Mapping(target = "visitNote", ignore = true)
    Visit mapFromEntity(VisitEntity visitEntity);

    @Mapping(target = "visit", ignore = true)
    PatientEntity mapToEntity(Patient patient);



}
