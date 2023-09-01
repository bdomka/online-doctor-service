package pl.zajavka.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

//    tak w tym tutorialu na stronce javaguides
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;


}
