package pl.zajavka.domain;

import lombok.Builder;
import lombok.Value;
import lombok.With;
import pl.zajavka.common.Gender;
import pl.zajavka.common.Status;

import java.time.OffsetDateTime;

@With
@Value
@Builder
public class VisitBooking {

    String existingPatientPesel;
    String patientName;
    String patientSurname;
    Gender patientGender;
    String patientPesel;
    OffsetDateTime patientMedicalHistoryDiagnosisDateTime;
    String patientMedicalHistoryIllnessName;
    String patientMedicalHistoryTreatment;
    String visitVisitNumber;
    OffsetDateTime visitVisitDateStartTime;
    OffsetDateTime visitVisitDatEndTime;
    Status visitStatus;
    String doctorLicenseNumber;

}
