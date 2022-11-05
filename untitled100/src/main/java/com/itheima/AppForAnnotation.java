package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import com.itheima.service.impl.BookServiceimpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppForAnnotation {
    public static void main(String[] args) {
        //加载配置类初始化容器
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        BookService bookService=ctx.getBean(BookService.class);
        bookService.save();

    }
}
