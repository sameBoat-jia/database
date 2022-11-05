package com.j2eeshiyan3.j2ee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


@Controller
public class template {
    public template() {
        Date date = new Date();
        Random ra = new Random();
        double num = ra.nextDouble() * (25 - 15) + 15;
        long time = date.getTime();
    }

    @GetMapping("/index")
    public ModelAndView start() {
        Connection conn = null;
        Statement stmt = null;
        final double[] res = {0};
        try {
            // 注册 JDBC 驱动
            Class.forName("org.mariadb.jdbc.Driver");
            // 打开链接
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/salary?user=root&password=z2621056241");
            // 执行查询
            stmt = conn.createStatement();
            Timer executeSchedule = new Timer();
            Statement finalStmt = stmt;
            executeSchedule.schedule(new TimerTask() {
                @Override
                public void run() {
                    float tp = (float) (Math.random() * 10 + 15);
                    BigDecimal tp1 = new BigDecimal(tp);
                    double tp2 = tp1.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
                        Timestamp nowdate = new Timestamp((System.currentTimeMillis()));
                        String datestr = sdf.format(nowdate);
                        res[0] = tp2;
                        int rs = finalStmt.executeUpdate("insert into sample(sample_time,sample_data) values('" + datestr + "','" + tp2 + "')");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }, 0, 5 * 1000);
        } catch (SQLException | ClassNotFoundException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        }
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("template", res[0]);
        return mv;
    }

    @GetMapping("/linechart")
    public String line() {
        System.out.println("进来了");
        return "linechart";
    }
    @GetMapping("/histogram")
    public String histo() {
        System.out.println("进来了");
        return "histogram";
    }
}


