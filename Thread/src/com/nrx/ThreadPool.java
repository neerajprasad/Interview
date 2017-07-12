package com.nrx;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {
	@SuppressWarnings("unchecked")
	private BlockingQueue taskQueue = null;
	private List<PoolThread> threads = new ArrayList<PoolThread>();
	public boolean isStopped = false;

	public ThreadPool(int noOfThreads,int maxNoOfThreads) {
		taskQueue = new ArrayBlockingQueue<>(maxNoOfThreads);
		
		for(int i=0;i< noOfThreads;i++) {
			threads.add(new PoolThread(taskQueue));
		}
		for(PoolThread thread : threads) {
			thread.start();
		}
	}
	@SuppressWarnings("unchecked")
	public  synchronized void execute(Runnable task) {
		if(this.isStopped) throw new IllegalThreadStateException("Thread is already stopped");
		try {
			this.taskQueue.put(task);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	public  synchronized void stop() {
		this.isStopped =true;
		for(PoolThread thread : threads) {
			thread.stopThread();
		}
	}


}
