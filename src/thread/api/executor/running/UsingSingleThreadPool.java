package thread.api.executor.running;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import thread.api.executor.commons.LoopTaskA;

public class UsingSingleThreadPool {
	public static void main(String[] args) {
		System.out.println("Main thread start here ....");
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(new LoopTaskA());
		executorService.execute(new LoopTaskA());
		executorService.execute(new LoopTaskA());
		executorService.execute(new LoopTaskA());
		executorService.execute(new LoopTaskA());
		executorService.execute(new LoopTaskA());
		executorService.shutdown();
		System.out.println("Main thread end here ....");
	}
}
