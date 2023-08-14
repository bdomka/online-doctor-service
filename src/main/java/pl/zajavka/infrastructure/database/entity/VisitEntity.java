package pl.zajavka.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;
import pl.zajavka.common.Status;

import java.time.OffsetDateTime;

@Getter
@Setter
@EqualsAndHashCode(of = "visitId")
@ToString(of = {"visitId"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "visit")
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visit_id")
    private Integer visitId;

    @Column(name = "visit_number", unique = true)
    private String visitNumber;

    @Column(name = "visit_date_start_time")
    private OffsetDateTime visitDateStartTime;

    @Column(name = "visit_date_end_time")
    private OffsetDateTime visitDateEndTime;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visit_note_id")
    private VisitNoteEntity visitNote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;

}
