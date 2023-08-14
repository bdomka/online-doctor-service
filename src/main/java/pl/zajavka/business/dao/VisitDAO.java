package pl.zajavka.business.dao;

import pl.zajavka.domain.Visit;

import java.util.Optional;
import java.util.Set;

public interface VisitDAO {

    Set<Visit> findScheduledVisitsByPatientPesel(String pesel);

    Set<Visit> findCompletedVisitsByPatientPesel(String pesel);

//    Set<Visit> findAvailableVisits();

    Set<Visit> findAvailableVisitsByDoctorLicenseNumber(String licenseNumber);

    void cancelVisit(String visitNumber);

    Optional<Visit> findVisitToBookByVisitNumber(String visitNumber);


//    void saveVisitNote(Visit visit);

}
