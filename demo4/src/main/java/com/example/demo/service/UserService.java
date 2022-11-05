package com.example.demo.service;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User queryById(int id)
    {
        return new User();
    }
    public void saveUser(User user)
    {
        System.out.println("新增用户。。。");
    }
}
