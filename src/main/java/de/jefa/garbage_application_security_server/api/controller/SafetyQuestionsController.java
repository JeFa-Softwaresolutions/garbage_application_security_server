package de.jefa.garbage_application_security_server.api.controller;

import de.jefa.garbage_application_security_server.api.model.TbSafetyQuestions;
import de.jefa.garbage_application_security_server.api.service.SafetyQuestionsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/safety_questions")
public class SafetyQuestionsController {

    private final SafetyQuestionsService safetyQuestionsService;

    public SafetyQuestionsController(SafetyQuestionsService safetyQuestionsService) {
        this.safetyQuestionsService = safetyQuestionsService;
    }

    @GetMapping
    public List<TbSafetyQuestions> getAllSafetyQuestions() {
        return safetyQuestionsService.findAll();
    }

    @GetMapping("/{systemId}")
    public TbSafetyQuestions getSafetyQuestionBySystemId(@PathVariable String systemId) {
        return safetyQuestionsService.findBySystemId(systemId);
    }
}