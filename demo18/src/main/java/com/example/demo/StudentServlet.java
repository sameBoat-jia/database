package com.example.demo;

import com.alibaba.dts.shade.javax.servlet.ServletException;
import com.alibaba.dts.shade.javax.servlet.annotation.WebServlet;
import com.alibaba.dts.shade.javax.servlet.http.HttpServlet;
import com.alibaba.dts.shade.javax.servlet.http.HttpServletRequest;
import com.alibaba.dts.shade.javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "StudentServlet ",value = "/student")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book=new Book("java how to program",50.0);
        req.setAttribute("book",book);
        req.getRequestDispatcher("/teacher").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
