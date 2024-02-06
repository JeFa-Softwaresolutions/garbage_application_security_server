package de.jefa.garbage_application_security_server.api.service;

import de.jefa.garbage_application_security_server.api.model.TbApiUsers;
import de.jefa.garbage_application_security_server.api.model.TbSuggestionUsers;
import de.jefa.garbage_application_security_server.api.repository.SuggestionUsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SuggestionUsersService {

    private final SuggestionUsersRepository suggestionUsersRepository;
    private final PasswordEncoder passwordEncoder;
    private final SafetyQuestionsService safetyQuestionsService;

    public SuggestionUsersService(SuggestionUsersRepository suggestionUsersRepository, PasswordEncoder passwordEncoder, SafetyQuestionsService safetyQuestionsService) {
        this.suggestionUsersRepository = suggestionUsersRepository;
        this.passwordEncoder = passwordEncoder;
        this.safetyQuestionsService = safetyQuestionsService;
    }

    public boolean saveUser(String userName, String password, String safetyAnswer1, String safetyAnswer2,
                            String safetyAnswer3, String systemIdSafetyQuestion1, String systemIdSafetyQuestion2,
                            String systemIdSafetyQuestion3) {
        final TbSuggestionUsers suggestionUser = new TbSuggestionUsers();
        suggestionUser.setUsername(userName);
        suggestionUser.setPassword(passwordEncoder.encode(password));
        suggestionUser.setSafetyAnswer1(safetyAnswer1);
        suggestionUser.setSafetyAnswer2(safetyAnswer2);
        suggestionUser.setSafetyAnswer3(safetyAnswer3);
        suggestionUser.setSafetyQuestion1Ref(safetyQuestionsService.findBySystemId(systemIdSafetyQuestion1).getAutoid());
        suggestionUser.setSafetyQuestion2Ref(safetyQuestionsService.findBySystemId(systemIdSafetyQuestion2).getAutoid());
        suggestionUser.setSafetyQuestion3Ref(safetyQuestionsService.findBySystemId(systemIdSafetyQuestion3).getAutoid());
        try {
            suggestionUsersRepository.save(suggestionUser);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public TbSuggestionUsers findByUserName(String userName) {
        return suggestionUsersRepository.findByUsername(userName);
    }
}