package pl.zajavka.infrastructure.database.repository.mapper;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pl.zajavka.domain.Doctor;
import pl.zajavka.domain.MedicalHistory;
import pl.zajavka.domain.Patient;
import pl.zajavka.domain.Visit;
import pl.zajavka.domain.VisitNote;
import pl.zajavka.infrastructure.database.entity.DoctorEntity;
import pl.zajavka.infrastructure.database.entity.MedicalHistoryEntity;
import pl.zajavka.infrastructure.database.entity.PatientEntity;
import pl.zajavka.infrastructure.database.entity.VisitEntity;
import pl.zajavka.infrastructure.database.entity.VisitNoteEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-02T00:37:52+0200",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 17 (Oracle Corporation)"
)
@Component
public class DoctorEntityMapperImpl implements DoctorEntityMapper {

    @Override
    public Doctor mapFromEntity(DoctorEntity doctorEntity) {
        if ( doctorEntity == null ) {
            return null;
        }

        Doctor.DoctorBuilder doctor = Doctor.builder();

        doctor.visits( mapVisits( doctorEntity.getVisits() ) );
        doctor.doctorId( doctorEntity.getDoctorId() );
        doctor.name( doctorEntity.getName() );
        doctor.surname( doctorEntity.getSurname() );
        doctor.speciality( doctorEntity.getSpeciality() );
        doctor.licenseNumber( doctorEntity.getLicenseNumber() );
        doctor.visitPrice( doctorEntity.getVisitPrice() );

        return doctor.build();
    }

    @Override
    public Visit mapFromEntity(VisitEntity visitEntity) {
        if ( visitEntity == null ) {
            return null;
        }

        Visit.VisitBuilder visit = Visit.builder();

        visit.visitId( visitEntity.getVisitId() );
        visit.visitNumber( visitEntity.getVisitNumber() );
        visit.visitDateStartTime( visitEntity.getVisitDateStartTime() );
        visit.visitDateEndTime( visitEntity.getVisitDateEndTime() );
        visit.status( visitEntity.getStatus() );

        return visit.build();
    }

    @Override
    public DoctorEntity mapToEntity(Doctor doctor) {
        if ( doctor == null ) {
            return null;
        }

        DoctorEntity.DoctorEntityBuilder doctorEntity = DoctorEntity.builder();

        doctorEntity.doctorId( doctor.getDoctorId() );
        doctorEntity.name( doctor.getName() );
        doctorEntity.surname( doctor.getSurname() );
        doctorEntity.speciality( doctor.getSpeciality() );
        doctorEntity.licenseNumber( doctor.getLicenseNumber() );
        doctorEntity.visitPrice( doctor.getVisitPrice() );
        doctorEntity.visits( visitSetToVisitEntitySet( doctor.getVisits() ) );

        return doctorEntity.build();
    }

    protected VisitNoteEntity visitNoteToVisitNoteEntity(VisitNote visitNote) {
        if ( visitNote == null ) {
            return null;
        }

        VisitNoteEntity.VisitNoteEntityBuilder visitNoteEntity = VisitNoteEntity.builder();

        visitNoteEntity.visitNoteId( visitNote.getVisitNoteId() );
        visitNoteEntity.visitNoteNumber( visitNote.getVisitNoteNumber() );
        visitNoteEntity.noteText( visitNote.getNoteText() );
        visitNoteEntity.visit( visitToVisitEntity( visitNote.getVisit() ) );

        return visitNoteEntity.build();
    }

    protected Set<VisitEntity> visitSetToVisitEntitySet(Set<Visit> set) {
        if ( set == null ) {
            return null;
        }

        Set<VisitEntity> set1 = new LinkedHashSet<VisitEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Visit visit : set ) {
            set1.add( visitToVisitEntity( visit ) );
        }

        return set1;
    }

    protected MedicalHistoryEntity medicalHistoryToMedicalHistoryEntity(MedicalHistory medicalHistory) {
        if ( medicalHistory == null ) {
            return null;
        }

        MedicalHistoryEntity.MedicalHistoryEntityBuilder medicalHistoryEntity = MedicalHistoryEntity.builder();

        medicalHistoryEntity.medicalHistoryId( medicalHistory.getMedicalHistoryId() );
        medicalHistoryEntity.illnessName( medicalHistory.getIllnessName() );
        medicalHistoryEntity.diagnosisDateTime( medicalHistory.getDiagnosisDateTime() );
        medicalHistoryEntity.treatment( medicalHistory.getTreatment() );
        medicalHistoryEntity.patient( patientToPatientEntity( medicalHistory.getPatient() ) );

        return medicalHistoryEntity.build();
    }

    protected Set<MedicalHistoryEntity> medicalHistorySetToMedicalHistoryEntitySet(Set<MedicalHistory> set) {
        if ( set == null ) {
            return null;
        }

        Set<MedicalHistoryEntity> set1 = new LinkedHashSet<MedicalHistoryEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( MedicalHistory medicalHistory : set ) {
            set1.add( medicalHistoryToMedicalHistoryEntity( medicalHistory ) );
        }

        return set1;
    }

    protected PatientEntity patientToPatientEntity(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientEntity.PatientEntityBuilder patientEntity = PatientEntity.builder();

        patientEntity.patientId( patient.getPatientId() );
        patientEntity.name( patient.getName() );
        patientEntity.surname( patient.getSurname() );
        patientEntity.gender( patient.getGender() );
        patientEntity.pesel( patient.getPesel() );
        patientEntity.email( patient.getEmail() );
        patientEntity.visits( visitSetToVisitEntitySet( patient.getVisits() ) );
        patientEntity.medicalHistories( medicalHistorySetToMedicalHistoryEntitySet( patient.getMedicalHistories() ) );

        return patientEntity.build();
    }

    protected VisitEntity visitToVisitEntity(Visit visit) {
        if ( visit == null ) {
            return null;
        }

        VisitEntity.VisitEntityBuilder visitEntity = VisitEntity.builder();

        visitEntity.visitId( visit.getVisitId() );
        visitEntity.visitNumber( visit.getVisitNumber() );
        visitEntity.visitDateStartTime( visit.getVisitDateStartTime() );
        visitEntity.visitDateEndTime( visit.getVisitDateEndTime() );
        visitEntity.status( visit.getStatus() );
        visitEntity.visitNote( visitNoteToVisitNoteEntity( visit.getVisitNote() ) );
        visitEntity.patient( patientToPatientEntity( visit.getPatient() ) );
        visitEntity.doctor( mapToEntity( visit.getDoctor() ) );

        return visitEntity.build();
    }
}
