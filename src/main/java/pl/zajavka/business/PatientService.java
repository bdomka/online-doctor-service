package pl.zajavka.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zajavka.business.dao.PatientDAO;
import pl.zajavka.domain.Patient;
import pl.zajavka.domain.exception.NotFoundException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientService {

    private final PatientDAO patientDAO;

    @Transactional
    public Patient findPatient(String pesel) {
        Optional<Patient> patient = patientDAO.findByPesel(pesel);
        if (patient.isEmpty()) {
            throw new NotFoundException("Could not find patient by pesel: [%s]".formatted(pesel));
        }
        return patient.get();
    }

    @Transactional
    public  void issueVisit(Patient patient){
        patientDAO.issueVisit(patient);
    }


    @Transactional
    public void saveVisit(Patient patient) {
        patientDAO.saveVisit(patient);
    }

    @Transactional
    public void saveMedicalHistory(Patient patient) {
        patientDAO.saveMedicalHistory(patient);
    }

    @Transactional
    public Patient savePatient(Patient patient) {
        return patientDAO.savePatient(patient);
    }

}
