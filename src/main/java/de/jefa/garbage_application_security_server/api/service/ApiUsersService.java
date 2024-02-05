package de.jefa.garbage_application_security_server.api.service;

import de.jefa.garbage_application_security_server.api.model.TbApiUsers;
import de.jefa.garbage_application_security_server.api.repository.ApiUsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ApiUsersService {

    private final ApiUsersRepository apiUsersRepository;
    private final PasswordEncoder passwordEncoder;

    public ApiUsersService(ApiUsersRepository apiUsersRepository, PasswordEncoder passwordEncoder) {
        this.apiUsersRepository = apiUsersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(String userName, String password) {
        final TbApiUsers user = new TbApiUsers();
        user.setUsername(userName);
        user.setPassword(passwordEncoder.encode(password));
        apiUsersRepository.save(user);
    }

    public TbApiUsers getUserByUsername(String username) {
        return apiUsersRepository.findByUsername(username);
    }
}
