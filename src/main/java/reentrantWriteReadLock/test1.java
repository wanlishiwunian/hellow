package reentrantWriteReadLock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class test1 {

    public static void main(String[] args) {
        test1 test1 = new test1();


        new Thread(()->{
            test1.write("下课了");
        },"徐老师").start();

        new Thread(()->{
            test1.write("没有课");
        },"李老师").start();

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                test1.read();
            },"同学"+i).start();
        }
    }

    private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd:HH:mm-->ss");

    public String getTime(){
        return sf.format(new Date());
    }
    ReentrantReadWriteLock rwl =  new ReentrantReadWriteLock();

    String content = "";

    public void write(String content){
        rwl.writeLock().lock();
        try{
            this.content = content;
            System.out.println(Thread.currentThread().getName()+"开始写入屏幕内容: "+content+"  时间是: "+getTime());
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwl.writeLock().unlock();
        }
    }

    public void read(){
        rwl.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"开始读取屏幕内容: "+content+"  时间是: "+getTime());
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwl.readLock().unlock();
        }
    }
}
