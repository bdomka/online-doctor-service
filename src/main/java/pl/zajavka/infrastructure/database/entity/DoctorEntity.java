package pl.zajavka.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "doctorId")
@ToString(of = {"doctorId", "name", "surname"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctor")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Integer doctorId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "license_number", unique = true)
    private String licenseNumber;

    @Column(name = "visit_price")
    private BigDecimal visitPrice;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "doctor")
    private Set<VisitEntity> visits;

}
