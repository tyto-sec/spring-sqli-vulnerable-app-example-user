package sec.tyto.sqli_vulnerable_app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sec.tyto.sqli_vulnerable_app.model.dto.LoginRequest;
import sec.tyto.sqli_vulnerable_app.model.dto.UserRequest;
import sec.tyto.sqli_vulnerable_app.model.dto.UserResponse;
import sec.tyto.sqli_vulnerable_app.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest loginRequest) {
        UserResponse userResponse = userService.findByUsernameAndPassword(loginRequest);
        if (userResponse != null) {
            return ResponseEntity.ok(userResponse);
        } else {
            return ResponseEntity.status(401).body(null); // Unauthorized
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<UserResponse>> findByUsername(@PathVariable String username) {
        List<UserResponse> users = userService.findByUsername(username);
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserRequest userRequest) {
        userService.insertUser(userRequest);
        return ResponseEntity.status(201).build(); // Created
    }

}
