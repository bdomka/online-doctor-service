package pl.zajavka.infrastructure.security;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.zajavka.api.dto.UserDto;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void saveUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getFirstName() + " " + userDto.getLastName());
        userEntity.setEmail(userDto.getEmail());
        // encrypt the password using spring security
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));

        RoleEntity role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        userEntity.setRoles(Arrays.asList(role));
        userRepository.save(userEntity);
    }

    @Override
    public UserEntity findUserByEmail(String email) {
        return userRepository.findByEmail(email);

    }

    private RoleEntity checkRoleExist(){
        RoleEntity role = new RoleEntity();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }


}
