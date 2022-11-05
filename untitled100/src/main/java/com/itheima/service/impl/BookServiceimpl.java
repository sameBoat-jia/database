package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service//业务层@Service
public class BookServiceimpl implements BookService {
    //删除业务成中使用new方式创建的对象
    @Value("${name}")
    private String name;
    @Autowired
    private BookDao bookDao;
    public void save(){
        System.out.println("book service save.........");
        System.out.println(name);
        bookDao.save();
    }
//提供对应的set方法
}
