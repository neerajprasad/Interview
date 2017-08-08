package threadPool;

public class Task implements Runnable {

	@Override
	public void run() {
		System.out.println("running task 0");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
