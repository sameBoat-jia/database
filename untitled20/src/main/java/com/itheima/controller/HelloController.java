package com.itheima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

///接下来编写处理器
@RestController
public class HelloController {
    @Autowired    //注入
    private DataSource dataSource;
    @GetMapping("hello")
    public String hello(){
        System.out.println("DataSource="+dataSource);
        return "Hello Spring Boot!";
    }
}
