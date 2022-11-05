package com.itheima.service;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User queryById(int id)
    {
        System.out.println(userMapper.selectByPrimaryKey(id));
        return userMapper.selectByPrimaryKey(id);
    }
    @Transactional
    public void saveUser(User user)
    {
        userMapper.insertSelective(user);

    }
}
