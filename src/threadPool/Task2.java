package threadPool;

public class Task2 implements Runnable {

	@Override
	public void run() {
		System.out.println("running task 2");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
