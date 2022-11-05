package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.UserXmlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Demo12ApplicationTests {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserXmlMapper userXmlMapper;
    @Test
    void testFindAll() {
        List<User>list=userXmlMapper.findAll();
        System.out.println(list);
    }

}
