package com.itheima.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

//@Configuration
public class JdbcConfig {
//    =com.mysql.cj.jdbc.Driver
//    jdbc.url=jdbc:mysql://localhost:3306/ssm_db
//    jdbc.username=root
//    jdbc.password=card1366
    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    public String username;
    @Value("${jdbc.password}")
    private String password;

    void a()
    {
        System.out.println(username);
    }


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
