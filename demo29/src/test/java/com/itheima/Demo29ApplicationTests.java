package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Demo29ApplicationTests {


    @Autowired
    private UserDao userDao;

    @Test
    void testSave()
    {
        User user = new User();
        user.setId(Long.valueOf(22));
        user.setAge(33);
        user.setName("aaaaaaaa");
        user.setTel(String.valueOf(3888));
        userDao.insert(user);
    }
    @Test
    void testGetId()
    {
        User user = new User();
        user.setId(1l);
        user.setName("aaaaaaaaa");
        userDao.updateById(user);
        System.out.println(user);
    }

    @Test
    void testDelete()
    {
        userDao.deleteById(22);
    }
    @Test
    void contextLoads() {
        List<User> userList=userDao.selectList(null);
        System.out.println(userList);
    }

}
