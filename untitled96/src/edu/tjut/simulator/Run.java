package edu.tjut.simulator;

public class Run {

	public static void main(String[] args) {
		System.out.println("模拟器开始");
		Simulator.StartSimulator(10000);
		Display.StartDisplayTempNow(0,10000);
		Display.StartDisplayTempAvg(60000,60000);
	}
}
