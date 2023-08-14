package pl.zajavka.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.zajavka.infrastructure.database.entity.MedicalHistoryEntity;

import java.util.Set;

@Repository
public interface MedicalHistoryJpaRepository extends JpaRepository<MedicalHistoryEntity, Integer> {

    @Query("""
            SELECT mh FROM MedicalHistoryEntity mh
            JOIN mh.patient p
            WHERE p.pesel = :pesel
            """)
    Set<MedicalHistoryEntity> findMedicalHistoriesByPatientPesel(@Param("pesel") String pesel);

}
