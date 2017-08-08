package thread.com.nrx;

public class MyRunn implements Runnable {


    @Override
    public void run(){
           if(Thread.currentThread().getName().equals("Thread-1"))
                  method1();
           else
                  method2();
    }
 
      synchronized void method1(){
           System.out.println(Thread.currentThread().getName()
                        +" in synchronized void method1() started");
           try {
                  Thread.sleep(2000);
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
           System.out.println(Thread.currentThread().getName()
                        +" in synchronized void method1() ended");
    }
    
    static synchronized void method2(){
           System.out.println(Thread.currentThread().getName()
                        +" in synchronized void method2() started");
           try {
                  Thread.sleep(2000);
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
           System.out.println(Thread.currentThread().getName()+
                        " in synchronized void method2() ended");
    }
    

}
