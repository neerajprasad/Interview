package com.nrx;

public class Task3 implements Runnable {

	@Override
	public void run() {
		System.out.println("running task 3");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
