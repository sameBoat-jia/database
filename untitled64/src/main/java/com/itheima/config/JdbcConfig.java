//package com.itheima.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//import javax.sql.DataSource;
//
//@Configuration
////@PropertySource("classpath:application.yml")
////@EnableConfigurationProperties(JdbcProperties.class)
//public class JdbcConfig {
////    @Value("${jdbc.url}")
////    String url;
////    @Value("${jdbc.username}")
////    String username;
////    @Value("${jdbc.password}")
////    String password;
////    @Value("${jdbc.driverClassName}")
////    String driverClassName;
////
////    @Bean
////    public DataSource dataSource(){
////        DruidDataSource dataSource = new DruidDataSource();
////        dataSource.setDriverClassName(driverClassName);
////        dataSource.setUrl(url);
////        dataSource.setUsername(username);
////        dataSource.setPassword(password);
////        return dataSource;
//
////    }
//@Bean
//@ConfigurationProper ties(prefix = "jdbc")
//public DataSource dataSource(){
//return  new DruidDataSource();
//    }
//}
