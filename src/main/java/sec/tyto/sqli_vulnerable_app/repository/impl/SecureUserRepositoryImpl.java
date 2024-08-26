package sec.tyto.sqli_vulnerable_app.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sec.tyto.sqli_vulnerable_app.model.User;
import sec.tyto.sqli_vulnerable_app.repository.UserRepository;

import java.util.List;

@Repository
@Qualifier("secureUserRepository")
public class SecureUserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        List<User> users = jdbcTemplate.query(sql, new Object[]{username, password}, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setBio(rs.getString("bio"));
            user.setPassword(rs.getString("password"));
            return user;
        });

        return users.isEmpty() ? null : users.get(0);
    }


    @Override
    public List<User> findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        List<User> users = jdbcTemplate.query(sql, new Object[]{username}, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setBio(rs.getString("bio"));
            user.setPassword(rs.getString("password"));
            return user;
        });

        return users;
    }

    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        if (findByUsername(user.getUsername()).isEmpty()){
            jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
        }
    }

}