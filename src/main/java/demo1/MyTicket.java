package demo1;

import com.sun.deploy.util.SyncAccess;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyTicket {
    public static void main(String[] args) {

        Sale sale = new Sale();
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sale.sale();
                }
            }).start();
        }
    }
}

 class Sale{

    private static long num = 100;

    Lock lock =  new ReentrantLock();

    public  void sale(){
        lock.lock();
        lock.unlock();
        try{
            num--;
            System.out.println(Thread.currentThread().getName()+"买走一张票,目前剩余票数: "+num);
        }finally {

        }

    }
}