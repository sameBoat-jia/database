package com.example.demo.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.example.demo.service"})
@PropertySource("classpath:application.properties")
@Import({JdbcConfig.class,MyBatisConfig.class})
public class SpringConfig {

}
