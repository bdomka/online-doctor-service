package pl.zajavka.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.zajavka.business.dao.PatientDAO;
import pl.zajavka.domain.Patient;
import pl.zajavka.infrastructure.database.entity.MedicalHistoryEntity;
import pl.zajavka.infrastructure.database.entity.PatientEntity;
import pl.zajavka.infrastructure.database.entity.VisitEntity;
import pl.zajavka.infrastructure.database.repository.jpa.MedicalHistoryJpaRepository;
import pl.zajavka.infrastructure.database.repository.jpa.PatientJpaRepository;
import pl.zajavka.infrastructure.database.repository.jpa.VisitJpaRepository;
import pl.zajavka.infrastructure.database.repository.mapper.MedicalHistoryEntityMapper;
import pl.zajavka.infrastructure.database.repository.mapper.PatientEntityMapper;
import pl.zajavka.infrastructure.database.repository.mapper.VisitEntityMapper;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class PatientRepository implements PatientDAO {

    private final PatientJpaRepository patientJpaRepository;

    private final VisitJpaRepository visitJpaRepository;

    private final MedicalHistoryJpaRepository medicalHistoryJpaRepository;

    private final PatientEntityMapper patientEntityMapper;

    private final VisitEntityMapper visitEntityMapper;

    private final MedicalHistoryEntityMapper medicalHistoryEntityMapper;

    @Override
    public Optional<Patient> findByPesel(String pesel) {
        return patientJpaRepository.findByPesel(pesel)
                .map(patientEntityMapper::mapFromEntity);
    }

    @Override
    public void issueVisit(Patient patient) {
        PatientEntity patientToSave = patientEntityMapper.mapToEntity(patient);
        PatientEntity patientSaved = patientJpaRepository.saveAndFlush(patientToSave);

        patient.getVisits().stream()
                // tutaj chciałam odfiltrować te vizyty które nie mają id i nie są jeszcze
                // w bazie danych
                // ale u mnie wizyty istnieja juz wczesniej wiec wszytkie maja id
                .filter(visit -> Objects.isNull(visit.getVisitId()))
                .map(visitEntityMapper::mapToEntity)
                .forEach(visitEntity -> {
                    visitEntity.setPatient(patientSaved);
                    visitJpaRepository.saveAndFlush(visitEntity);
                });
    }

    @Override
    public void saveVisit(Patient patient) {
        List<VisitEntity> visits = patient.getVisits().stream()
                .filter(visit -> Objects.isNull(visit.getVisitId()))
                .map(visitEntityMapper::mapToEntity)
                .toList();

        visits
                .forEach(request -> request.setPatient(patientEntityMapper.mapToEntity(patient)));
        visitJpaRepository.saveAllAndFlush(visits);
    }

    @Override
    public void saveMedicalHistory(Patient patient) {
        List<MedicalHistoryEntity> medicalHistories = patient.getMedicalHistories().stream()
                .filter(medicalHistory -> Objects.isNull(medicalHistory.getMedicalHistoryId()))
                .map(medicalHistoryEntityMapper::mapToEntity)
                .toList();

        medicalHistories
                .forEach(request -> request.setPatient(patientEntityMapper.mapToEntity(patient)));
        medicalHistoryJpaRepository.saveAllAndFlush(medicalHistories);
    }

    @Override
    public Patient savePatient(Patient patient) {
        PatientEntity toSave = patientEntityMapper.mapToEntity(patient);
        PatientEntity saved = patientJpaRepository.save(toSave);
        return patientEntityMapper.mapFromEntity(saved);
    }
}
