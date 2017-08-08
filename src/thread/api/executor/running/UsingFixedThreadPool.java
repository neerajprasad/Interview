package thread.api.executor.running;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import thread.api.executor.commons.LoopTaskA;

public class UsingFixedThreadPool {
	public static void main(String[] args) {
		System.out.println("Main thread start here ....");
		ExecutorService executorService = Executors.newFixedThreadPool(6);
		executorService.execute(new LoopTaskA());
		executorService.execute(new LoopTaskA());
		executorService.execute(new LoopTaskA());
		executorService.execute(new LoopTaskA());
		executorService.execute(new LoopTaskA());
		executorService.execute(new LoopTaskA());
		executorService.shutdown();
		executorService.execute(new LoopTaskA());
		System.out.println("Main thread end here ....");
	}
}
