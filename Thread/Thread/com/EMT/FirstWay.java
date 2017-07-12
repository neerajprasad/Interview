package com.EMT;

import java.util.concurrent.TimeUnit;

public class FirstWay {
	public static void main(String[] args) {
		System.out.println("Main thread start here ....");
		new FirstTask();
		new FirstTask();
		System.out.println("Main thread end here ....");
	}
}

class FirstTask extends Thread {
	private static int count=0;
	private int id;
	@Override
	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.println("<"+id+">tick tick :" + i);

			try {
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public FirstTask() {
		this.id=++count;
		this.start();
	}
}