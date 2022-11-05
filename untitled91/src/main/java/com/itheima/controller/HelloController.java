package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.sql.DataSource;

public class HelloController {
    @Autowired
    DataSource dataSource;
    private UserService userService;
    @GetMapping("/user/{id}")
    public User queryBId(@PathVariable int id)
    {
        return userService.queryById(id);
    }
}
