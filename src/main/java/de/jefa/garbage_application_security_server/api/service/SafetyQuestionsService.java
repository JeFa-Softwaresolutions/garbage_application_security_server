package de.jefa.garbage_application_security_server.api.service;

import de.jefa.garbage_application_security_server.api.model.TbSafetyQuestions;
import de.jefa.garbage_application_security_server.api.repository.SafetyQuestionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SafetyQuestionsService {

    private final SafetyQuestionsRepository safetyQuestionsRepository;

    public SafetyQuestionsService(SafetyQuestionsRepository safetyQuestionsRepository) {
        this.safetyQuestionsRepository = safetyQuestionsRepository;
    }

    public List<TbSafetyQuestions> findAll() {
        return safetyQuestionsRepository.findAll();
    }

    public TbSafetyQuestions findBySystemId(String systemId) {
        return safetyQuestionsRepository.findBySystemId(systemId).get(0);
    }
}
