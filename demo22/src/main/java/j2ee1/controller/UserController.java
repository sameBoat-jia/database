package j2ee1.controller;

import com.example.j2ee1.model.User;
import com.example.j2ee1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("login")
    private int login(@RequestParam("username")String username,
                      @RequestParam("password")String password){
        return userService.login(username, password);
    }

    @GetMapping("getAll")
    private List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("getAllLogin")
    private List<User> getAllLogin(){
        return userService.getAllLogin();
    }
}
