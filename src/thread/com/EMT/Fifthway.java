package thread.com.EMT;

import java.util.concurrent.TimeUnit;

//quick an dirty technique
public class Fifthway {
	public static void main(String[] args) {
		System.out.println("Main thread start here ....");
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 10; i > 0; i--) {
					System.out.println("tick tick :" + i);

					try {
						TimeUnit.MILLISECONDS.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		});
		t.start();

		System.out.println("Main thread end here ....");
	}
}