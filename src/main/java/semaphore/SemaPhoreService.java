package semaphore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 如果想让run方法中执行这段代码,那么需要证明做呢?
 * 把这个类变成那个继承了Thread的类或者实现了Runnable的接口的类
 * 弄成属性,然后通过构造器传入,这样就可以使用了;
 *
 * 好方法就是通过构造器传进来,通过构造器传进来,那么需要把这个东西变成属性,那么就出来了
 * 即: 属性中添加这个类,然后通过构造器传进来,然后就可以调用了;
 */
public class SemaPhoreService {

    //定义一个时间格式,这个格式可以在统计时间的时候使用;
    private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");

    //关键同步类,这个里面的参数决定了同时允许多少个线程同时运行代码;
    private Semaphore semaphore = new Semaphore(2);
    Lock lock = new ReentrantLock();

    public void doSomething(){

        try{
            //在semaphore.acquire()和semaphore.release()之间的代码只允许定制个数的线程进入
            //因为semaphore的构造方法是1,同一个时刻只允许一个线程进入,其他线程等待
            semaphore.acquire(); //进入一个就占用两个通路; 6/2 说明可以进入三个线程;
            lock.lock();
            doSomethingMain();
            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private  void doSomethingMain() throws InterruptedException {
        //统计时间
        System.out.println(Thread.currentThread().getName()+" , doSomething: start --  "+FormatTimeStr());
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName()+" , doSomething: end ----- "+FormatTimeStr());
    }

    public static String FormatTimeStr(){
        return sf.format(new Date());
    }

    public int availablePermits(){
        int i = semaphore.availablePermits();
        return i;
    }
}
