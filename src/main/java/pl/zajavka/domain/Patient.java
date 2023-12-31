package pl.zajavka.domain;

import lombok.*;
import pl.zajavka.common.Gender;

import java.util.Set;

@With
@Value
@Builder
@EqualsAndHashCode(of = "patientId")
@ToString(of = {"patientId", "name", "surname", "pesel"})
public class Patient {

    Integer patientId;
    String name;
    String surname;
    Gender gender;
    String pesel;
    String email;
//    UserEntity userEntity; by wyciągnąć user id przy bookowaniu wizyty ???
    Set<Visit> visits;
    Set<MedicalHistory> medicalHistories;

}
