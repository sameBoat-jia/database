package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.dao.impl.BookDaoImpl;
import com.itheima.service.BookService;

public class BookServiceImpl implements BookService {
    //删除业务层中使用new方式创建的dao对象
    private BookDao bookDao;
    @Override
    public void save() {
        System.out.println("book service save.....");
        bookDao.save();
    }
//提供对应的set方法
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
