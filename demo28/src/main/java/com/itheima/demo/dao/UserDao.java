package com.itheima.demo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {


}
