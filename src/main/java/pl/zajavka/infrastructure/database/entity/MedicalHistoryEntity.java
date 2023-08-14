package pl.zajavka.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(of = "medicalHistoryId")
@ToString(of = {"medicalHistoryId", "illnessName", "diagnosisDateTime"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medical_history")
public class MedicalHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medical_history_id")
    private Integer medicalHistoryId;

    @Column(name = "illness_name")
    private String illnessName;

    @Column(name = "diagnosis_date_time")
    private OffsetDateTime diagnosisDateTime;

    @Column(name = "treatment")
    private String treatment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;
}
