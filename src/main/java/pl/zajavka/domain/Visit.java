package pl.zajavka.domain;

import lombok.*;
import pl.zajavka.common.Status;

import java.time.OffsetDateTime;
import java.util.Set;

@With
@Value
@Builder
@EqualsAndHashCode(of = "visitId")
@ToString(of = {"visitId", "visitNumber"})
public class Visit {

    Integer visitId;
    String visitNumber;
    OffsetDateTime visitDateStartTime;
    OffsetDateTime visitDateEndTime;
    Status status;
    Patient patient;
    Doctor doctor;
    VisitNote visitNote;
}
