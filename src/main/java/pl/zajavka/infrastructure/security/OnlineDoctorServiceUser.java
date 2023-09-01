package pl.zajavka.infrastructure.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OnlineDoctorServiceUser implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(),
                    mapRolesToAuthorities(user.getRoles()));
        }else{
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Collection <RoleEntity> roles) {
        Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return mapRoles;
    }

//    @Override
//    public UserDetails loadUserByUsername(String email) {
//        UserEntity user = userRepository.findByEmail(email);
//        List<SimpleGrantedAuthority> authorities = getUserAuthority(user.getRoles());
//        return buildUserForAuthentication(user, authorities);
//    }
//    private List<SimpleGrantedAuthority> getUserAuthority(Set<RoleEntity> roles) {
//        return roles.stream()
//                .map(role -> new SimpleGrantedAuthority(role.getRole()))
//                .distinct()
//                .toList();
//
//    }
//    private UserDetails buildUserForAuthentication(UserEntity user, List<SimpleGrantedAuthority> authorities) {
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(),
//                user.getPassword(),
//                user.getActive(),
//                true,
//                true,
//                true,
//                authorities
//        );

    }

