package pl.zajavka.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;
import pl.zajavka.common.Gender;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(of = "patientId")
@ToString(of = {"patientId", "name", "surname", "pesel"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "pesel", unique = true)
    private String pesel;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
    private Set<VisitEntity> visits;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
    private Set<MedicalHistoryEntity> medicalHistories;

}
