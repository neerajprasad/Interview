package threadPool;

public class Task1 implements Runnable {

	@Override
	public void run() {
		System.out.println("running task 1");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
