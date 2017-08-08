package thread.api.executor.commons;

import java.util.concurrent.TimeUnit;

public class LoopTaskA implements Runnable {
	private static int count=0;
	private int id;
	@Override
	public void run() {
		System.out.println("#############TAsk -"+id+"> STARTING ##########");
		for (int i = 10; i > 0; i--) {
			System.out.println("<"+id+">tick tick :" + i);

			try {
				TimeUnit.MILLISECONDS.sleep((long)Math.random()*10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("#############TAsk -"+id+"> ENDING ##########");
	}

	public LoopTaskA() {
		this.id=++count;
	}
}
