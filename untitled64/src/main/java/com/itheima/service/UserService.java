package com.itheima.service;

import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User queryById(Long id){
        return new User();
    }
    public void saveUser(User user){
        System.out.println("新增用户");
    }
}
