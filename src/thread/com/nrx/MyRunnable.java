package thread.com.nrx;

public class MyRunnable implements Runnable {

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName() + " is waiting for lock");
		synchronized (this) {
			try {
				System.out.println(Thread.currentThread().getName() + " has acquired lock");
				Thread.sleep(2000); // sleep for 2 seconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " has ended");
		}

	}

}
