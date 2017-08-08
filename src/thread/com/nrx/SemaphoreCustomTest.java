package thread.com.nrx;

class SemaphoreCustom{
    
    private int permits;
    
    /** permits is the initial number of permits available.
           This value can be negative, in which case releases must occur
           before any acquires will be granted, permits is number of threads
           that can access shared resource at a time.
           If permits is 1, then only one threads that can access shared
           resource at a time.
    */
    public SemaphoreCustom(int permits) {
           this.permits=permits;
    }
 
    /**Acquires a permit if one is available and decrements the
       number of available permits by 1.
           If no permit is available then the current thread waits
           until one of the following things happen >
            >some other thread calls release() method on this semaphore or,
            >some other thread interrupts the current thread.
    */
    public synchronized void acquire() throws InterruptedException {
           //Acquires a permit, if permits is greater than 0 decrements
           //the number of available permits by 1.
           if(permits > 0){
                  permits--;
           }
           //permit is not available wait, when thread
           //is notified it decrements the permits by 1
           else{
                  this.wait();
                  permits--;
           }
    }
 
    /** Releases a permit and increases the number of available permits by 1.
           For releasing lock by calling release() method it’s not mandatory
           that thread must have acquired permit by calling acquire() method.
    */
    public synchronized void release() {
           //increases the number of available permits by 1.
           permits++;
           
           //If permits are greater than 0, notify waiting threads.
           if(permits > 0)
                  this.notifyAll();
    }
}

 
/**
 * Main class, for testing SemaphoreCustom
 */
public class SemaphoreCustomTest {
 
    static int SharedValue=0;
    
    public static void main(String[] args) {
           SemaphoreCustom semaphore=new SemaphoreCustom(1);
           System.out.println("Semaphore with 1 permit has been created");
           
           IncrementThread incrementThread=new IncrementThread(semaphore);
           new Thread(incrementThread,"incrementThread").start();
           
           DecrementThread decrementThread=new DecrementThread(semaphore);
           new Thread(decrementThread,"decrementThread").start();
           
    }
}
 



 
 
class IncrementThread implements Runnable{
 
    SemaphoreCustom semaphoreCustom;
    
    public IncrementThread(SemaphoreCustom semaphoreCustom) {
           this.semaphoreCustom=semaphoreCustom;        
    }
    
    public void run(){
           System.out.println(Thread.currentThread().getName()+
                        " is waiting for permit");
           try {
                  semaphoreCustom.acquire();
                  System.out.println(Thread.currentThread().getName()+
                               " has got permit");
           
                  for(int i=0;i<5;i++){
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+
                                      " > "+SemaphoreCustomTest.SharedValue++);
                  }
                  
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
           
           System.out.println(Thread.currentThread().getName()+
                        " has released permit");
           semaphoreCustom.release();
    
    }
    
}





 
class DecrementThread implements Runnable{
 
    SemaphoreCustom semaphoreCustom;
    public DecrementThread(SemaphoreCustom semaphoreCustom){
           this.semaphoreCustom=semaphoreCustom;
    }
    
    public void run(){
           System.out.println(Thread.currentThread().getName()+
                        " is waiting for permit");
           
           try {
                  semaphoreCustom.acquire();
                  System.out.println(Thread.currentThread().getName()+
                               " has got permit");
           
                  for(int i=0;i<5;i++){          
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+
                                      " >"+SemaphoreCustomTest.SharedValue--);
                  }
                  
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
           
           
           System.out.println(Thread.currentThread().getName()+
                        " has released permit");
           semaphoreCustom.release();
           
           
    }
    
}