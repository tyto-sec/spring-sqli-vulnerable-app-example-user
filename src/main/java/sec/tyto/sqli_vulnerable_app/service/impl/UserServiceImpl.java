package sec.tyto.sqli_vulnerable_app.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import sec.tyto.sqli_vulnerable_app.mapper.UserMapper;
import sec.tyto.sqli_vulnerable_app.model.dto.LoginRequest;
import sec.tyto.sqli_vulnerable_app.model.dto.UserRequest;
import sec.tyto.sqli_vulnerable_app.model.dto.UserResponse;
import sec.tyto.sqli_vulnerable_app.repository.UserRepository;
import sec.tyto.sqli_vulnerable_app.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService  {

    private UserMapper userMapper;
    private UserRepository userRepository;

    public UserServiceImpl(UserMapper userMapper, @Qualifier("vulnerableUserRepository") UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public UserResponse findByUsernameAndPassword(LoginRequest login) {
        return userMapper.map(userRepository.findByUsernameAndPassword(login.getUsername(), login.getPassword()));
    }

    public List<UserResponse> findByUsername(String username) {
        return userRepository.findByUsername(username).stream().map(user -> userMapper.map(user)).toList();
    }

    public void insertUser(UserRequest user) {
        userRepository.insertUser(userMapper.map(user));
    }

}
