package pl.zajavka.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zajavka.domain.Visit;

import java.util.Set;

@Service
@AllArgsConstructor
public class VisitPatientManagementService {

    private final VisitService visitService;
    private final PatientService patientService;

    public Set<Visit> completedVisits(String pesel){
        return visitService.findCompletedVisits(pesel);
    }

    public Set<Visit> scheduledVisits(String pesel){
        return visitService.findScheduledVisits(pesel);
    }

    @Transactional
    public void cancelVisit(String visitNumber){
        visitService.cancelVisit(visitNumber);
    }





}
