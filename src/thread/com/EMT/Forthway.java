package thread.com.EMT;

import java.util.concurrent.TimeUnit;

public class Forthway {
	public static void main(String[] args) {
		System.out.println("Main thread start here ....");
		new Thread(new ForthTask()).start();
		Thread t = new Thread(new ForthTask());
		t.start();
		System.out.println("Main thread end here ....");
	}
}

class ForthTask implements Runnable {
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

	public ForthTask() {
		this.id=++count;
	}
}