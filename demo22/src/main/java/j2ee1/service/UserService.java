package j2ee1.service;

import com.example.j2ee1.model.User;

import java.util.List;

public interface UserService {

    int login(String username,String password);

    List<User> getAll();

    List<User> getAllLogin();
}
