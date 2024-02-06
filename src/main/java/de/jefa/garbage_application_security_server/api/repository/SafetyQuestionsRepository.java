package de.jefa.garbage_application_security_server.api.repository;

import de.jefa.garbage_application_security_server.api.model.TbSafetyQuestions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SafetyQuestionsRepository extends JpaRepository<TbSafetyQuestions, Long> {

    List<TbSafetyQuestions> findBySystemId(String systemId);
}
