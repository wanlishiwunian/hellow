package semaphore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreService3 {

    private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss");
    private Semaphore semaphore = new Semaphore(6,true);

    public String getTime(){
        String format = sf.format(new Date());
        return format;
    }

    public int availablePermits(){
       return  semaphore.availablePermits();
    }

    public void doSomething(){
        try{
            if (semaphore.tryAcquire(2,3,TimeUnit.SECONDS)){

                System.out.println(Thread.currentThread().getName()+"doSomething start : "+getTime());
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+"doSomething end   : "+getTime()+",当前是否有线程等待: " +
                        ""+semaphore.hasQueuedThreads()+",等待的线程数量: "+semaphore.getQueueLength());
            }else {
                System.out.println(Thread.currentThread().getName()+"没有获取到锁-准备退出-"+getTime());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            semaphore.release(2);
        }

    }

}
