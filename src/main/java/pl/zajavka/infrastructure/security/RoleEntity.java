package pl.zajavka.infrastructure.security;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "online_doctor_service_role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;

//    @Column(name = "role")
//    private String role;

    @Column(name = "name")
    private String name;

    // jak z Set to beż tego
    @ManyToMany(mappedBy="roles")
    private List<UserEntity> users;

}
