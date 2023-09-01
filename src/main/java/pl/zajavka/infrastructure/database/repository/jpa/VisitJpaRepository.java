package pl.zajavka.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.zajavka.infrastructure.database.entity.VisitEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface VisitJpaRepository extends JpaRepository<VisitEntity, Integer> {

    // pacjent moze sprawdzic odbyte wizyty i kiedy wypadają nadchodzace wizyty
    @Query("""
            SELECT v FROM VisitEntity v
            WHERE v.status = 'SCHEDULED'
            AND v.patient.pesel = :pesel
            """)
    Set<VisitEntity> findScheduledVisitsByPatientPesel(final @Param("pesel") String pesel);


    @Query("""
            SELECT v FROM VisitEntity v
            WHERE v.status = 'COMPLETED'
            AND v.patient.pesel = :pesel
            """)
    Set<VisitEntity> findCompletedVisitsByPatientPesel(final @Param("pesel") String pesel);

    @Query(value = """
            SELECT v FROM VisitEntity v
            WHERE v.status = 'AVAILABLE'
            """)
    Set<VisitEntity> findAvailableVisits();


    @Query("""
            SELECT v FROM VisitEntity v
            WHERE v.status = 'AVAILABLE'
            AND v.doctor.licenseNumber = :licenseNumber
            """)
    List<VisitEntity> findAvailableVisitsByDoctorLicenseNumber(final @Param("licenseNumber") String licenseNumber);


   // odwołać wizytę
   @Query("""
        UPDATE VisitEntity v
        SET v.status = 'AVAILABLE'
        WHERE v.status = 'SCHEDULED'
        AND v.visitNumber = :visitNumber
        """)
   @Modifying(clearAutomatically = true)
   void cancelVisitByVisitNumber(@Param("visitNumber") String visitNumber);

   Optional<VisitEntity> findVisitToBookByVisitNumber(String visitNumber);

}
