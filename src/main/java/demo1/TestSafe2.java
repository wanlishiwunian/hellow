package demo1;

/**
 * 同步的两种形式:
 * 1 同步代码块
 * 2 同步方法: 同步方法的锁对象是:
 * 2-1 非静态方法: 锁对象是this
 * 2-2 静态方法:锁对象是类
 */
public class TestSafe2 {
    public static void main(String[] args) {
        SaleTicket6 saleTicket1 = new SaleTicket6("窗口1 ");
        SaleTicket6 saleTicket2 = new SaleTicket6("窗口2 ");
        saleTicket1.start();
        saleTicket2.start();
    }
}

class SaleTicket6 extends Thread{
    private static int count = 10;
    private static final Object lock = new Object();

    public SaleTicket6(String name) {
        super(name);
    }

    @Override
    public void run() {
        while(count>0){
            SaleOneTicket();
        }
    }

    private static synchronized void SaleOneTicket() {
        if(count>0){
            count--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"卖出了1一张票,现在还剩下 "+count+"张票");
        }
    }
}
