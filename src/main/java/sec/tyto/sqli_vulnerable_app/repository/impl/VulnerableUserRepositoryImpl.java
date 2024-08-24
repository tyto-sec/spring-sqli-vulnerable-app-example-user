package sec.tyto.sqli_vulnerable_app.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sec.tyto.sqli_vulnerable_app.model.User;
import sec.tyto.sqli_vulnerable_app.repository.UserRepository;

import java.util.List;

@Repository
@Qualifier("vulnerableUserRepository")
public class VulnerableUserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
        List<User> users = jdbcTemplate.query(sql, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setBio(rs.getString("bio"));
            user.setPassword(rs.getString("password"));
            return user;
        });

        return users.isEmpty() ? null : users.get(0);
    }

    public List<User> findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = '" + username + "'";
        List<User> users = jdbcTemplate.query(sql, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setBio(rs.getString("bio"));
            user.setPassword(rs.getString("password"));
            return user;
        });

        return users;
    }

    public void insertUser(User user) {
        String sql = "INSERT INTO users (username, password, bio) VALUES ('" + user.getUsername() + "', '"
                + user.getPassword()  + "', '" + user.getBio() + "')";
        jdbcTemplate.execute(sql);
    }

}
