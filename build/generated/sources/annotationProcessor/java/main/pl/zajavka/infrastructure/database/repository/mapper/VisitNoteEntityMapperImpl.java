package pl.zajavka.infrastructure.database.repository.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pl.zajavka.domain.VisitNote;
import pl.zajavka.infrastructure.database.entity.VisitNoteEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-02T00:37:52+0200",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 17 (Oracle Corporation)"
)
@Component
public class VisitNoteEntityMapperImpl implements VisitNoteEntityMapper {

    @Override
    public VisitNote mapFromEntity(VisitNoteEntity visitNoteEntity) {
        if ( visitNoteEntity == null ) {
            return null;
        }

        VisitNote.VisitNoteBuilder visitNote = VisitNote.builder();

        visitNote.visitNoteId( visitNoteEntity.getVisitNoteId() );
        visitNote.visitNoteNumber( visitNoteEntity.getVisitNoteNumber() );
        visitNote.noteText( visitNoteEntity.getNoteText() );

        return visitNote.build();
    }

    @Override
    public VisitNote mapToEntity(VisitNoteEntity visitNoteEntity) {
        if ( visitNoteEntity == null ) {
            return null;
        }

        VisitNote.VisitNoteBuilder visitNote = VisitNote.builder();

        visitNote.visitNoteId( visitNoteEntity.getVisitNoteId() );
        visitNote.visitNoteNumber( visitNoteEntity.getVisitNoteNumber() );
        visitNote.noteText( visitNoteEntity.getNoteText() );

        return visitNote.build();
    }
}
