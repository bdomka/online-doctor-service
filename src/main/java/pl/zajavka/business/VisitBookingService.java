package pl.zajavka.business;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zajavka.business.dao.VisitDAO;
import pl.zajavka.domain.MedicalHistory;
import pl.zajavka.domain.Patient;
import pl.zajavka.domain.Visit;
import pl.zajavka.domain.VisitBooking;

import java.util.Set;

@Service
@AllArgsConstructor
public class VisitBookingService {

    private final VisitService visitService;

    private final PatientService patientService;


    // to controller bedzie uzywal
    public Set<Visit> availableVisits(String licenseNumber) {
        return visitService.findAvailableVisits(licenseNumber);
    }

    @Transactional
    public Visit book(VisitBooking visitForBooking) {
        return visitForBooking.getExistingPatientPesel().isEmpty()
                ? initialVisitBooking(visitForBooking)
                : subsequentVisitBooking(visitForBooking);
    }

    @Transactional
    public Visit initialVisitBooking(VisitBooking bookingVisit) {

        Visit visit = visitService.visitToBook(bookingVisit.getVisitVisitNumber());

        Visit bookedVisit = buildBookedVisit(visit, patient); // no i tu dupa
        Patient patient = buildPatient(bookingVisit, bookedVisit);
        patientService.issueVisit(patient);
        return bookedVisit;
    }


    @Transactional
    public Visit subsequentVisitBooking(VisitBooking bookingVisit) {
        Patient existingPatient = patientService.findPatient(bookingVisit.getExistingPatientPesel());
        Visit visit = visitService.visitToBook(bookingVisit.getVisitVisitNumber());
        Visit bookedVisit = buildBookedVisit(visit, existingPatient);
        Set<Visit> existingBookedVisits = existingPatient.getVisits();
        existingBookedVisits.add(bookedVisit);
        patientService.issueVisit(existingPatient.withVisits(existingBookedVisits));
        return bookedVisit;
    }


    private Visit buildBookedVisit(Visit visit, Patient patient) {
        return Visit.builder()
                .visitNumber(visit.getVisitNumber())
                .visitDateStartTime(visit.getVisitDateStartTime())
                .visitDateEndTime(visit.getVisitDateEndTime())
                .status(visit.getStatus())
                .patient(patient)
                .doctor(visit.getDoctor())
                .visitNote(visit.getVisitNote()) // ona pusta jest, bo to jest dopiero bookowanie wizyty to null poleci, to bez tego raczej
                // czy osobny service VisitDoctorManagementService gdzie właśnie te notatki doktor moze dodać ???
                // czy osobny VisitPatientManagementService gdzie może cancel visit ???  to i visit history może razem ??
                // i mam Visit History w domenie by pacjent mogł przeglądać te poprzednie wizyty i tutaj też może zobaczyć visitNote to tu też servis czy to do jednego gdzie moze odwołać ???
                .build();
    }

    private Patient buildPatient(VisitBooking visitBooking, Visit visit) {
        return Patient.builder()
                .name(visitBooking.getPatientName())
                .surname(visitBooking.getPatientSurname())
                .gender(visitBooking.getPatientGender())
                .pesel(visitBooking.getPatientPesel())
                .medicalHistories(Set.of(MedicalHistory.builder()
                        .illnessName(visitBooking.getPatientMedicalHistoryIllnessName())
                        .diagnosisDateTime(visitBooking.getPatientMedicalHistoryDiagnosisDateTime())
                        .treatment(visitBooking.getPatientMedicalHistoryTreatment())
                        .build()))
                .visits(Set.of(visit))
                .build();
    }


}

