package pl.zajavka.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@With
@Value
@Builder
@EqualsAndHashCode(of = "doctorId")
@ToString(of = {"doctorId", "name", "surname"})
public class Doctor {

    Integer doctorId;
    String name;
    String surname;
    String speciality;
    String licenseNumber;
    BigDecimal visitPrice;
    Set<Visit> visits;
}
