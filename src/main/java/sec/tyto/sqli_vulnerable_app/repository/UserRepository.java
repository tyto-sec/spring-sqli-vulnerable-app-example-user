package sec.tyto.sqli_vulnerable_app.repository;

import sec.tyto.sqli_vulnerable_app.model.User;

import java.util.List;

public interface UserRepository {
    User findByUsernameAndPassword(String username, String password);
    List<User> findByUsername(String username);
    void insertUser(User user);
}
