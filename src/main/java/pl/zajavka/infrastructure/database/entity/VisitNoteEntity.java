package pl.zajavka.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(of = "visitNoteId")
@ToString(of = {"visitNoteId"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "visit_note")
public class VisitNoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visit_note_id")
    private Integer visitNoteId;

    @Column(name = "visit_note_number", unique = true)
    private String visitNoteNumber;

    @Column(name = "note_text")
    private String noteText;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "visitNote")
    private VisitEntity visit;
}
