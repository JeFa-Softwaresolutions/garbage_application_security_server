package de.jefa.garbage_application_security_server.api.service;

import de.jefa.garbage_application_security_server.api.model.TbApiUsers;
import de.jefa.garbage_application_security_server.api.repository.ApiUsersRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final ApiUsersRepository apiUsersRepository;

    public CustomUserDetailService(ApiUsersRepository apiUsersRepository, PasswordEncoder passwordEncoder) {
        this.apiUsersRepository = apiUsersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final TbApiUsers apiUsers = apiUsersRepository.findByUsername(username);

        return User.builder()
                .username(apiUsers.getUsername())
                .password(apiUsers.getPassword())
                .roles("USER")
                .build();
    }
}
