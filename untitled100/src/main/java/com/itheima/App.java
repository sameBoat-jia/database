package com.itheima;

import com.itheima.service.BookService;
import com.itheima.service.impl.BookServiceimpl;

public class App {
    public static void main(String[] args) {
        BookService bookService=new BookServiceimpl();
        bookService.save();
    }
}
