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
    date = "2023-09-02T00:37:51+0200",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 17 (Oracle Corporation)"
)
@Component
public class VisitEntityMapperImpl implements VisitEntityMapper {

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
        visit.patient( patientEntityToPatient( visitEntity.getPatient() ) );
        visit.doctor( doctorEntityToDoctor( visitEntity.getDoctor() ) );

        return visit.build();
    }

    @Override
    public VisitEntity mapToEntity(Visit visit) {
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
        visitEntity.doctor( doctorToDoctorEntity( visit.getDoctor() ) );

        return visitEntity.build();
    }

    protected Set<Visit> visitEntitySetToVisitSet(Set<VisitEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<Visit> set1 = new LinkedHashSet<Visit>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( VisitEntity visitEntity : set ) {
            set1.add( mapFromEntity( visitEntity ) );
        }

        return set1;
    }

    protected MedicalHistory medicalHistoryEntityToMedicalHistory(MedicalHistoryEntity medicalHistoryEntity) {
        if ( medicalHistoryEntity == null ) {
            return null;
        }

        MedicalHistory.MedicalHistoryBuilder medicalHistory = MedicalHistory.builder();

        medicalHistory.medicalHistoryId( medicalHistoryEntity.getMedicalHistoryId() );
        medicalHistory.illnessName( medicalHistoryEntity.getIllnessName() );
        medicalHistory.diagnosisDateTime( medicalHistoryEntity.getDiagnosisDateTime() );
        medicalHistory.treatment( medicalHistoryEntity.getTreatment() );
        medicalHistory.patient( patientEntityToPatient( medicalHistoryEntity.getPatient() ) );

        return medicalHistory.build();
    }

    protected Set<MedicalHistory> medicalHistoryEntitySetToMedicalHistorySet(Set<MedicalHistoryEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<MedicalHistory> set1 = new LinkedHashSet<MedicalHistory>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( MedicalHistoryEntity medicalHistoryEntity : set ) {
            set1.add( medicalHistoryEntityToMedicalHistory( medicalHistoryEntity ) );
        }

        return set1;
    }

    protected Patient patientEntityToPatient(PatientEntity patientEntity) {
        if ( patientEntity == null ) {
            return null;
        }

        Patient.PatientBuilder patient = Patient.builder();

        patient.patientId( patientEntity.getPatientId() );
        patient.name( patientEntity.getName() );
        patient.surname( patientEntity.getSurname() );
        patient.gender( patientEntity.getGender() );
        patient.pesel( patientEntity.getPesel() );
        patient.email( patientEntity.getEmail() );
        patient.visits( visitEntitySetToVisitSet( patientEntity.getVisits() ) );
        patient.medicalHistories( medicalHistoryEntitySetToMedicalHistorySet( patientEntity.getMedicalHistories() ) );

        return patient.build();
    }

    protected Doctor doctorEntityToDoctor(DoctorEntity doctorEntity) {
        if ( doctorEntity == null ) {
            return null;
        }

        Doctor.DoctorBuilder doctor = Doctor.builder();

        doctor.doctorId( doctorEntity.getDoctorId() );
        doctor.name( doctorEntity.getName() );
        doctor.surname( doctorEntity.getSurname() );
        doctor.speciality( doctorEntity.getSpeciality() );
        doctor.licenseNumber( doctorEntity.getLicenseNumber() );
        doctor.visitPrice( doctorEntity.getVisitPrice() );
        doctor.visits( visitEntitySetToVisitSet( doctorEntity.getVisits() ) );

        return doctor.build();
    }

    protected VisitNoteEntity visitNoteToVisitNoteEntity(VisitNote visitNote) {
        if ( visitNote == null ) {
            return null;
        }

        VisitNoteEntity.VisitNoteEntityBuilder visitNoteEntity = VisitNoteEntity.builder();

        visitNoteEntity.visitNoteId( visitNote.getVisitNoteId() );
        visitNoteEntity.visitNoteNumber( visitNote.getVisitNoteNumber() );
        visitNoteEntity.noteText( visitNote.getNoteText() );
        visitNoteEntity.visit( mapToEntity( visitNote.getVisit() ) );

        return visitNoteEntity.build();
    }

    protected Set<VisitEntity> visitSetToVisitEntitySet(Set<Visit> set) {
        if ( set == null ) {
            return null;
        }

        Set<VisitEntity> set1 = new LinkedHashSet<VisitEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Visit visit : set ) {
            set1.add( mapToEntity( visit ) );
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

    protected DoctorEntity doctorToDoctorEntity(Doctor doctor) {
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
}
