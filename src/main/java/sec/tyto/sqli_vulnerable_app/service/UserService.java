package sec.tyto.sqli_vulnerable_app.service;

import sec.tyto.sqli_vulnerable_app.model.dto.LoginRequest;
import sec.tyto.sqli_vulnerable_app.model.dto.UserRequest;
import sec.tyto.sqli_vulnerable_app.model.dto.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse findByUsernameAndPassword(LoginRequest login);
    List<UserResponse> findByUsername(String username);
    void insertUser(UserRequest user);
}
