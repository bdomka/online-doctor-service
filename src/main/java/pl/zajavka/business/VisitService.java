package pl.zajavka.business;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.zajavka.business.dao.VisitDAO;
import pl.zajavka.domain.Visit;
import pl.zajavka.domain.exception.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@Slf4j
@Service
@AllArgsConstructor
public class VisitService {

    private final VisitDAO visitDAO;


    @Transactional
    public Set<Visit> findScheduledVisits(String pesel){
        Set<Visit> activeVisits = visitDAO.findScheduledVisitsByPatientPesel(pesel);
        log.info("Active visits: [{}]", activeVisits.size());
        return activeVisits;
    }

    @Transactional
    public Set<Visit> findCompletedVisits(String pesel){
        Set<Visit> completedVisits = visitDAO.findCompletedVisitsByPatientPesel(pesel);
        log.info("Completed visits: [{}]", completedVisits.size());
        return completedVisits;
    }


//    @Transactional
//    public Set<Visit> findAvailableVisits(){
//        Set<Visit> availableVisits = visitDAO.findAvailableVisits();
//        log.info("Available visits: [{}]", availableVisits.size());
//        return availableVisits;
//    };

    @Transactional
    public Set<Visit> findAvailableVisits(String licenseNumber){
        Set<Visit> availableVisits = visitDAO.findAvailableVisitsByDoctorLicenseNumber(licenseNumber);
        log.info("Available visits: [{}]", availableVisits.size());
        return availableVisits;
    };

    @Transactional
    public Visit visitToBook(String visitNumber){
        Optional<Visit> visitToBookByVisitNumber = visitDAO.findVisitToBookByVisitNumber(visitNumber);
        if (visitToBookByVisitNumber.isEmpty()) {
            throw new NotFoundException("Could not find visit by visit number: [%s]".formatted(visitNumber));
        }
        return visitToBookByVisitNumber.get();
    }

    @Transactional
    public void cancelVisit(String visitNumber){
        visitDAO.cancelVisit(visitNumber);
    };


}
