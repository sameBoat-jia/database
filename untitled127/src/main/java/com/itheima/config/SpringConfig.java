package com.itheima.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/*
spring核心配置文件
 */
@Configuration//设置是个配置类
@ComponentScan("com.itheima.service")//设置扫描路径
@PropertySource("classpath:Jdbc.properties")//配置文件加载一些属性
@Import({JdbcConfig.class,MyBatisConfig.class})//导入配置类
public class SpringConfig {

}
