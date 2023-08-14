package pl.zajavka.domain;

import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "visitNoteId")
@ToString(of = {"visitNoteId"})
public class VisitNote {

    Integer visitNoteId;
    String visitNoteNumber;
    String noteText;
    Visit visit;


}
