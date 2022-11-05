package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class JdbcConfig {
//    =com.mysql.cj.jdbc.Driver
//    jdbc.url=jdbc:mysql://localhost:3306/ssm_db
//    jdbc.username=root
//    jdbc.password=card1366
//    @Value("${jdbc.driver}")
    @Value("com.mysql.cj.jdbc.Driver")
    private String driver;
//    @Value("${jdbc.url}")
    @Value("jdbc:mysql://localhost:3306/ssm_db")
    private String url;
//    @Value("${jdbc.username}")
    @Value("root")
    private String username;
//    @Value("${jdbc.password}")
    @Value("card1366")
    private String password;
    @Bean
    public DataSource dataSource()
    {

        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
