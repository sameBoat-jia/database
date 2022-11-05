package com.example.demo;

import com.example.demo.service.TempService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
class Demo30ApplicationTests {

    @Autowired
    private TempService tempService;
    @Test
    void contextLoads() {
        System.out.println(tempService.getTemperature());
    }

}
