package de.jefa.garbage_application_security_server.api.controller;

import de.jefa.garbage_application_security_server.api.model.TbApiUsers;
import de.jefa.garbage_application_security_server.api.service.ApiUsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/api-users")
public class ApiUsersController {

    private final ApiUsersService apiUsersService;

    public ApiUsersController(ApiUsersService apiUsersService) {
        this.apiUsersService = apiUsersService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestParam String userName, @RequestParam String password) {
        if(apiUsersService.saveUser(userName, password)) {
            return ResponseEntity.ok("User created successfully");
        } else {
            return ResponseEntity.ok("User could not be created");
        }
    }

    @GetMapping("/{username}")
    public TbApiUsers getUserByUsername(@PathVariable String username) {
        return apiUsersService.getUserByUsername(username);
    }
}
