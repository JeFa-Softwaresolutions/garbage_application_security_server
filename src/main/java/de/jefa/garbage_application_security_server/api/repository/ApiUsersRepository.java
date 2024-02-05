package de.jefa.garbage_application_security_server.api.repository;

import de.jefa.garbage_application_security_server.api.model.TbApiUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApiUsersRepository extends JpaRepository<TbApiUsers, Long> {

    public TbApiUsers findByUsername(String username);
}
