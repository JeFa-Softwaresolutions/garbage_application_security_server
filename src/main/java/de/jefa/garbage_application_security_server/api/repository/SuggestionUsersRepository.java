package de.jefa.garbage_application_security_server.api.repository;

import de.jefa.garbage_application_security_server.api.model.TbApiUsers;
import de.jefa.garbage_application_security_server.api.model.TbSuggestionUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestionUsersRepository extends JpaRepository<TbSuggestionUsers, Long> {

    public TbSuggestionUsers findByUsername(String username);
}
