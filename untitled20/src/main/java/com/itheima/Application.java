package com.itheima;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring boot工程都有一个启动引导类，这是工程的入口类
 * 并在引导类上添加@SpringBootApplication
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //启动引导类
        //入口类是application
        SpringApplication.run(Application.class,args);
    }
}

