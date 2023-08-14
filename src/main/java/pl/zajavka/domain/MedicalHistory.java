package pl.zajavka.domain;

import lombok.*;

import java.time.OffsetDateTime;

@With
@Value
@Builder
@EqualsAndHashCode(of = "medicalHistoryId")
@ToString(of = {"medicalHistoryId", "illnessName"})
public class MedicalHistory {

    Integer medicalHistoryId;
    String illnessName;
    OffsetDateTime diagnosisDateTime;
    String treatment;
    Patient patient;

}
