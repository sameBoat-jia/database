package com.j2eeshiyan3.j2ee.domain;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Minute {
    public int count = 0;
    Connection conn = null;

    public Minute(Connection connection) {
        this.count = 0;
        this.conn = connection;
    }

    public float showavg() {
        final float[] resl = {0};
        Connection conn;
        Statement stmt;
        final ResultSet[] rs = new ResultSet[1];
        try {
            // 注册 JDBC 驱动
            final float[] templates = {0};
            final float[] template = {0};
            final Date[] times = {new Date()};
            Class.forName("org.mariadb.jdbc.Driver");
            // 打开链接
            conn = this.conn;
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
                        rs[0] = finalStmt.executeQuery("select sample_time,sample_data from sample where date_sub(now(),interval 1 minute) < sample_time");
                        while (rs[0].next()) {
                            // 通过字段检索
                            times[0] = rs[0].getTime("sample_time");
                            template[0] = rs[0].getFloat("sample_data");
                            templates[0] += template[0];
                            count += 1;
                        }
                        System.out.print("最近1分钟------time: " + times[0]);
                        System.out.print("，templates_avg: " + templates[0] / count);
                        System.out.print("\n");
                        resl[0] = templates[0] / count;
                        count = 0;
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }, 0, 10 * 6 * 1000);

        } catch (SQLException | ClassNotFoundException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        }
        return resl[0];
    }
}
