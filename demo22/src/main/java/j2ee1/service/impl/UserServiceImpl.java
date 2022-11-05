package j2ee1.service.impl;

import com.example.j2ee1.mapper.UserMapper;
import com.example.j2ee1.model.User;
import com.example.j2ee1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public int login(String username, String password) {
        if (userMapper.findUserByUsername(username) != null) {
            User user = userMapper.findUserByUsername(username);
            if (user.getPassword().equals(password)) {
                user.setIsLogin(true);
                userMapper.save(user);
                return 1;
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }

    public List<User> getAll() {
        return userMapper.findAll();
    }

    public List<User> getAllLogin() {
        return userMapper.findAllByIsLoginTrue();
    }
}
