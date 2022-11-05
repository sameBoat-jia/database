package edu.tjut.simulator;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import edu.tjut.simulator.DBUtil;

public class Display {

	private Timestamp ts;
	private Timestamp bts;
	ArrayList<HashMap<String, String>> dataSet;

	public Display() {
		ts = new Timestamp(new Date().getTime());
		bts = new Timestamp(ts.getTime() - 60000);
	}

	private double SelectTempAvg() {
		try {
			//字符串 组织SQL语句
			String sql = "SELECT sample_data FROM sample WHERE sample_time BETWEEN '"+ bts +"' AND '"+ ts +"'";
			//执行查询操作
			dataSet=DBUtil.getDataSet(sql);
			double temp = 0;
			for(int i=0;i<dataSet.size();i++){
				temp+=Double.parseDouble(dataSet.get(i).get("sample_data"));
			}
			temp/=dataSet.size();
			return temp;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	private double SelectTempNow() {
		try {
			//字符串 组织SQL语句
			String sql = "SELECT sample_data FROM sample ORDER BY sample_time DESC LIMIT 1";
			//执行查询操作
			dataSet=DBUtil.getDataSet(sql);
			return Double.parseDouble(dataSet.get(0).get("sample_data"));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static void StartDisplayTempNow(int delay,int time) {
		Timer timer = new Timer();

		// 前一次执行程序结束后 60s 后开始执行下一次程序
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("==============================");
				System.out.println("当前时间:" + new Timestamp(new Date().getTime()));
				System.out.printf("当前温度：%.1f℃\n",new Display().SelectTempNow());
				System.out.println("==============================");
			}
		}, delay, time);
	}

	public static void StartDisplayTempAvg(int delay,int time) {
		Timer timer = new Timer();

		// 前一次执行程序结束后 (time)ms 后开始执行下一次程序
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("==============================");
				System.out.println("当前时间:" + new Timestamp(new Date().getTime()));
				System.out.printf("平均温度：%.1f℃\n",new Display().SelectTempAvg());
				System.out.println("==============================");
			}
		}, delay, time);
		
	}
}
