package test4;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class test extends Thread{
    SendTemperature sendTemperature=new SendTemperature();
    ShowTemperature showTemperature=new ShowTemperature();
    alertSystem alertSystem=new alertSystem();
    public static void main(String[] args) throws Exception {
        test test1=new test();
        int time = 0;
        while (true){
            while(time%6!=5){
                test1.sendTemperature.insert();
                System.out.println("Now temperature"+test1.showTemperature.getTemperatureByTime(1).get(0).toString());
                test1.alertSystem.warn(test1.showTemperature.getTemperatureByTime(6));
                time++;
                System.out.println();
                Thread.sleep(10000);
            }
            time=0;
            time++;
            test1.sendTemperature.insert();
            test1.showTemperature.getAverageTemperatureBy60();
            System.out.println();
            Thread.sleep(10000);
        }
    }

    @Override
    public void run() {
        sendTemperature.start();
        showTemperature.start();
        alertSystem.start();
    }

    public static class alertSystem extends Thread{
        ShowTemperature showTemperature=new ShowTemperature();
        public boolean warn(ArrayList<Double> results)
        {
            int errorCount=0;
            if(results!=null)
            {
                for (Double res :
                        results) {
                    if (res < 198.0 || res > 22) {
                        errorCount++;
                    }
                    }
            }
            else {
                System.out.println("预警系统缺乏数据，请稍等！");
                return false;
            }
            if (errorCount==results.size())
            {
                System.out.println("阈值以达到长达一分钟");

            }return true;
        }

        @Override
        public void run() {
            while (true)
            {
                try{
                    this.warn(this.showTemperature.getTemperatureByTime(6));
                    sleep(10000);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class SendTemperature extends Thread{
        private String url="jdbc:mysql://localhost:3306/java_exp?user=root&password=card1366&useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
        private String sql;
        private PreparedStatement preparedStatement;
        private Connection connection;
        ResultSet res;
        boolean resultInsert;
        public void insert()throws SQLException
        {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            }catch (ClassNotFoundException e)
            {
                e.printStackTrace();
                return;
            }
            connection= DriverManager.getConnection(url);
            sql="insert into sample(sample_time,sample_data)value(?,?);";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1,new Timestamp(new Date().getTime()));
            preparedStatement.setBigDecimal(2, BigDecimal.valueOf(15+10*Math.random()));
            resultInsert=preparedStatement.execute();
            preparedStatement.close();
            preparedStatement.close();
        }

        @Override
        public void run() {
            while (true)
            {
                try {
                    this.insert();
                    sleep(10000);
                }catch (Exception e)
                {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    public static class ShowTemperature extends Thread{
        private String url="jdbc:mysql://localhost:3306/java_exp?user=root&password=card1366&useUnicode=true&characterEncoding=utf8&useSSL=ture&serverTimezone=UTC";
        private String sql  ;
        private PreparedStatement preparedStatement;
        private Connection connection;
        ResultSet res;
        ArrayList<Double>temperature=new ArrayList<>();
        public ArrayList<Double>getTemperatureByTime(int time)throws SQLException
        {
            temperature.clear();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            }catch (ClassNotFoundException e)
            {
                e.printStackTrace();
                return null;
            }
            connection= DriverManager.getConnection(url);
            sql="select*from sample order by sample_time desc limit "+time;
            preparedStatement=connection.prepareStatement(sql);
            res=preparedStatement.executeQuery();
            Boolean bool=res.next();
            if (!bool)
            {
                return null;
            }
            while (bool)
            {
                temperature.add(Double.valueOf(res.getString(2)));
                bool=res.next();
            }
            preparedStatement.close();
            connection.close();
            if (temperature.size()==time)
            {
                return temperature;
            }else {
                System.out.println("数据量不足");
                return null;
            }
        }
        public double getAverageTemperatureBy60()throws SQLException
        {
            Double result=0.0;
            ArrayList<Double>results=getTemperatureByTime(6);
            if (results==null)
            {
                System.out.println("数据库记录不足六条，无法提取平均温度");
                return -2;
            }
            for (double data :
                    results) {
                result += data;
            }
            result=result/results.size();
            System.out.println("一分钟平均温度是" +
                    result);
            return result;
        }

        @Override
        public void run() {
            int k=0;
            while (true)
            {
                try {
                    System.out.println("实时温度：" +
                            this.getTemperatureByTime(1).get(0).doubleValue());
                    k++;
                    sleep(10000);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
                if(k%6==0)
                {
                    k=0;
                    try {
                        this.getAverageTemperatureBy60();
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
