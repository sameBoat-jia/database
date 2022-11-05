package edu.tjut.simulator;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;



public class Simulator {

	private double MAX = 25;
	private double MIN = 15;
	private double randTemperature;
	private Timestamp ts;
	
	public Simulator() {
		randTemperature = (MIN + new Random().nextDouble() * (MAX - MIN));
		randTemperature = (double) Math.round(randTemperature * 10) / 10;
		ts = new Timestamp(new Date().getTime());
	}

	public boolean InsertIntoDB() {
		try {
			//字符串 组织SQL语句
			String sql = "INSERT INTO sample(sample_time,sample_data) VALUES('"+ts+"','"+randTemperature+"')";
			//执行插入操作
			if(DBUtil.executeBatch(sql)){
				return true;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void StartSimulator() {
		Timer timer = new Timer();
        //前一次执行程序结束后 10s 后开始执行下一次程序
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Simulator().InsertIntoDB();
            }
        }, 0,10000);
	}

	public static void StartSimulator(int time) {
		Timer timer = new Timer();
        //前一次执行程序结束后 (time)ms 后开始执行下一次程序
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Simulator().InsertIntoDB();
            }
        }, 0,time);
	}
}
