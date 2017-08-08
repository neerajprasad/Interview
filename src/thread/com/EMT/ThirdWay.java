package thread.com.EMT;

import java.util.concurrent.TimeUnit;
// fire and forgot
public class ThirdWay {
	public static void main(String[] args) {
		System.out.println("Main thread start here ....");
		new ThirdTask();
		new ThirdTask();
		System.out.println("Main thread end here ....");
	}
}

class ThirdTask implements Runnable {
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

	public ThirdTask() {
		this.id=++count;
		new Thread(this).start();
	}
}