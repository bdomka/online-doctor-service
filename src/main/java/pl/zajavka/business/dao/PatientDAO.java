package pl.zajavka.business.dao;

import pl.zajavka.domain.Patient;

import java.util.Optional;

public interface PatientDAO {

    Optional<Patient> findByPesel(String pesel);

    void issueVisit(Patient patient);

    void saveVisit(Patient patient); // to do innego podejscia w VisitBookingService było

    void saveMedicalHistory(Patient patient);

    Patient savePatient(Patient patient);

}
