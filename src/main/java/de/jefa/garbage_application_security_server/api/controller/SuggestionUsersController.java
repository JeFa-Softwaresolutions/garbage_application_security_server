package de.jefa.garbage_application_security_server.api.controller;

import de.jefa.garbage_application_security_server.api.model.TbSuggestionUsers;
import de.jefa.garbage_application_security_server.api.service.SuggestionUsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suggestion_users")
public class SuggestionUsersController {

    private final SuggestionUsersService suggestionUsersService;

    public SuggestionUsersController(SuggestionUsersService suggestionUsersService) {
        this.suggestionUsersService = suggestionUsersService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestParam String userName, @RequestParam String password,
                                        @RequestParam String safetyAnswer1, @RequestParam String safetyAnswer2,
                                        @RequestParam String safetyAnswer3, @RequestParam String systemIdSafetyQuestion1,
                                        @RequestParam String systemIdSafetyQuestion2, @RequestParam String systemIdSafetyQuestion3) {
        if(suggestionUsersService.saveUser(userName, password, safetyAnswer1, safetyAnswer2, safetyAnswer3, systemIdSafetyQuestion1,
                systemIdSafetyQuestion2, systemIdSafetyQuestion3)) {
            return ResponseEntity.ok("User created successfully");
        } else {
            return ResponseEntity.ok("User could not be created");
        }
    }

    @GetMapping("/{userName}")
    public TbSuggestionUsers getByUserName(@PathVariable String userName) {
        return suggestionUsersService.findByUserName(userName);
    }
}
