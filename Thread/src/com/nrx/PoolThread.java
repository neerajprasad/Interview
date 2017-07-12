package com.nrx;

import java.util.concurrent.BlockingQueue;

public class PoolThread extends Thread {
	private BlockingQueue taskQueue = null;
	private boolean isStopped = false;

	public PoolThread(BlockingQueue taskQueue) {
		this.taskQueue = taskQueue;
	}

	public void run() {
		while(!isStopped()) {
			try {
				Runnable runnable =(Runnable) taskQueue.take();
				runnable.run();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isStopped() {
		return isStopped;
	}

	public void setStopped(boolean isStopped) {
		this.isStopped = isStopped;
	}

	public void stopThread() {
		isStopped = true;
		
	}

}
