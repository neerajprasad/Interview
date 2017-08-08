package threadPool;

import java.util.Random;

public class MainThreadPool {
	public  static void main(String[] args) 
	 {
		Task t = new Task();
		Task1 t1 = new Task1();
		Task2 t2 = new Task2();
		Task3 t3 = new Task3();
		
		int taskCount=0;
		ThreadPool tp =new ThreadPool(2, 2);
		while(taskCount <40) {
			Random ram=new Random();
			int n = ram.nextInt(4);
			if(n==0) {
				tp.execute(t);
			}
			else if (n==1) {
				tp.execute(t1);
			}
			else if (n==2) {
				tp.execute(t2);
			}
			else if (n==3) {
				tp.execute(t3);
			}
			taskCount++;
//			tp.stop();
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
}
