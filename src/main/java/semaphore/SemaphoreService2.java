package semaphore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

public class SemaphoreService2 {

    private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

    public String getTime(){
        String format = sf.format(new Date());
        return format;
    }
    //有几个通道就可以让几个线程进入,当然前提是这个线程是只占用一个通道,这个对通道数量的设置在acquire(?)中
    private Semaphore semaphore2 =  new Semaphore(6);

    public void doSomething(){

        try {
            semaphore2.acquire(2);
            System.out.println(Thread.currentThread().getName()+"doSomething start : "+getTime());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+"doSomething end   : "+getTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore2.release(1);
        }
    }
    public int availablePermits(){
       return  semaphore2.availablePermits();
    }
}
