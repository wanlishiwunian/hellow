package demo1;

import sun.awt.windows.ThemeReader;

/**
 *
 * 锁对象的时候一般用this,如果this不管用可以再造一个
 */
public class TestSafe3 {
    public static void main(String[] args) {
        SaleTicket11 saleTicket11 = new SaleTicket11();

        Thread thread1 = new Thread(saleTicket11);
        Thread thread2 = new Thread(saleTicket11);
        Thread thread3 = new Thread(saleTicket11);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class SaleTicket11 implements Runnable{

    private  int count = 10;

    @Override
    public void run() {
        while(count>0){
            synchronized (this){
                if (count>0){
                    count--;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"查询当前票数是:"+count);
                }
            }
        }
    }
}