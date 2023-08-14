package pl.zajavka.infrastructure.database.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.zajavka.infrastructure.database.entity.VisitNoteEntity;

import java.util.Set;

@Repository
public interface VisitNoteJpaRepository extends JpaRepository<VisitNoteEntity, Integer> {

    @Query("""
            SELECT vn FROM VisitNoteEntity vn 
            WHERE vn.visit.visitId = :visitId
            """)
    Set<VisitNoteEntity> findVisitNoteByVisitId(@Param("visitId") Integer visitId);
}
