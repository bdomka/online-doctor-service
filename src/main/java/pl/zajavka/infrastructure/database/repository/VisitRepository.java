package pl.zajavka.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.zajavka.business.dao.VisitDAO;
import pl.zajavka.domain.Visit;
import pl.zajavka.domain.VisitNote;
import pl.zajavka.infrastructure.database.entity.VisitNoteEntity;
import pl.zajavka.infrastructure.database.repository.jpa.VisitJpaRepository;
import pl.zajavka.infrastructure.database.repository.jpa.VisitNoteJpaRepository;
import pl.zajavka.infrastructure.database.repository.mapper.VisitEntityMapper;
import pl.zajavka.infrastructure.database.repository.mapper.VisitNoteEntityMapper;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class VisitRepository implements VisitDAO{

    private final VisitJpaRepository visitJpaRepository;
    private final VisitNoteJpaRepository visitNoteJpaRepository;
    private final VisitEntityMapper visitEntityMapper;
    private final VisitNoteEntityMapper visitNoteEntityMapper;

    @Override
    public Set<Visit> findActiveVisitsByPatientPesel(String pesel) {
        return visitJpaRepository.findScheduledVisitsByPatientPesel(pesel).stream()
                .map(visitEntityMapper::mapFromEntity)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Visit> findCompletedVisitsByPatientPesel(String pesel) {
        return visitJpaRepository.findCompletedVisitsByPatientPesel(pesel).stream()
                .map(visitEntityMapper::mapFromEntity)
                .collect(Collectors.toSet());
    }

//    @Override
//    public Set<Visit> findAvailableVisits() {
//        return visitJpaRepository.findAvailableVisits().stream()
//                .map(visitEntityMapper::mapFromEntity)
//                .collect(Collectors.toSet());
//    }

    @Override
    public Set<Visit> findAvailableVisitsByDoctorLicenseNumber(String licenseNumber) {
        return visitJpaRepository.findAvailableVisitsByDoctorLicenseNumber(licenseNumber).stream()
                .map(visitEntityMapper::mapFromEntity)
                .collect(Collectors.toSet());
    }

    @Override
    public void cancelVisit(Integer visitId) {
        visitJpaRepository.cancelVisitByVisitId(visitId);
    }

    @Override
    public Optional<Visit> findVisitToBookByVisitNumber(String visitNumber) {
        return visitJpaRepository.findVisitToBookByVisitNumber(visitNumber)
                .map(visitEntityMapper::mapFromEntity);
    }


//    @Override
//    public void saveVisitNote(Visit visit) {
//      // nie wiem jak to
//    }


}
