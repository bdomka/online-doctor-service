package pl.zajavka.domain;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;
import pl.zajavka.common.Status;

import java.time.OffsetDateTime;
import java.util.List;

@Value
@Builder
@ToString(of = "pesel")
public class VisitHistory {

    String visitNumber;
    List<Visit> visits;

    @Value
    @Builder
    @ToString(of = {"visitDateStartTime", "visitDateEndTime", "status"})
    private static class Visit {
        OffsetDateTime visitDateStartTime;
        OffsetDateTime visitDateEndTime;
        Status status;
        VisitNote visitNote;
        List<VisitNote> visitNotes;
    }
}
