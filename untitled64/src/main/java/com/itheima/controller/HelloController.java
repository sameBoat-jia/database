package com.itheima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class HelloController {


    @Autowired
    private DataSource dataSource;
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("DataSource="+dataSource);
        return "hahaha";
    }
}