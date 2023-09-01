package pl.zajavka.infrastructure.security;

import pl.zajavka.api.dto.UserDto;

public interface UserService {
    void saveUser(UserDto userDto);
    UserEntity findUserByEmail(String email);

}
