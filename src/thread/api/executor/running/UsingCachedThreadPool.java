package thread.api.executor.running;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import thread.api.executor.commons.LoopTaskA;

public class UsingCachedThreadPool {
	public static void main(String[] args) {
		System.out.println("Main thread start here ....");
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new LoopTaskA());
		executorService.execute(new LoopTaskA());
		executorService.execute(new LoopTaskA());
		executorService.execute(new LoopTaskA());
		executorService.execute(new LoopTaskA());
		executorService.execute(new LoopTaskA());
		executorService.execute(new LoopTaskA());
		System.out.println("Main thread end here ....");
	}
}
