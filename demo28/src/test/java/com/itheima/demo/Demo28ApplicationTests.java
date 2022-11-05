package com.itheima.demo;

import com.itheima.demo.dao.UserDao;
import com.itheima.demo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Demo28ApplicationTests {

    @Autowired
    private UserDao userDao;
    @Test
    void testGetALL() {
        List<User> users = userDao.selectList(null);
        System.out.println(users);
    }

}
