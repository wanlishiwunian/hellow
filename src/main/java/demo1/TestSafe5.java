package demo1;

public class TestSafe5 {
    public static void main(String[] args) {
        SaleTicket22 saleTicket22 = new SaleTicket22("111");
        Thread thread = new Thread(saleTicket22);
        Thread thread2 = new Thread(saleTicket22);
        Thread thread3 = new Thread(saleTicket22);
        thread.start();
        thread2.start();
        thread3.start();
    }
}

class SaleTicket22 implements Runnable{

    private String name;
    private int count = 10;

    public SaleTicket22(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (count>0){

                saleOneTicket();

        }
    }

    private synchronized void saleOneTicket() {
        if (count>0){
            count--;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"卖了一张票,还剩下"+count+"张票");
        }
    }
}
