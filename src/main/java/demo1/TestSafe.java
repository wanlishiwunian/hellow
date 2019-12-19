package demo1;

/**
 * 栈:局部变量,无法共享
 * 堆:可以共享,但是要保证是同一个对象的
 * 方法区:可以共享,这里是静态数据,只要是同一个类就可以了;
 *
 *
 * 这是一个错误的方法,
 */
public class TestSafe {
    public static void main(String[] args) {
        SaleTicket3 saleTicket1 = new SaleTicket3("111");
        SaleTicket3 saleTicket2 = new SaleTicket3("22222");
        SaleTicket3 saleTicket3 = new SaleTicket3("333333333");
        SaleTicket3 saleTicket4 = new SaleTicket3("4444444444444");
        SaleTicket3 saleTicket5 = new SaleTicket3("555555555555555555");
        saleTicket1.start();
        saleTicket2.start();
        saleTicket3.start();
        saleTicket4.start();
        saleTicket5.start();
    }
}

/**
 *
 * 这是一个错误的方法,这个数据不能被共享,是一个局部变量,所以是错误的
 * 不能这么写;
class SaleTicket extends Thread{

    public SaleTicket(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 10; i >=1 ; i--) {
            System.out.println(Thread.currentThread().getName()+"卖了一张票,还剩下 : "+i+"张票");
        }
    }
}
 */


/*


这样是三个买票的 ,都有自己的票,而不是共享一个只有20张;
class SaleTicket2 extends Thread{

    private int count;

    public SaleTicket2(String name, int count) {
        super(name);
        this.count = count;
    }

    @Override
    public void run() {
        while(count>0){
            System.out.println(Thread.currentThread().getName()+"买了一张票,还剩下 : "+count-- +"票");
        }
    }
}
*/

class SaleTicket3 extends Thread {

    private static  int count = 20;
    private static final Object Lock = new Object();

    public SaleTicket3(String name) {
        super(name);
    }

    @Override
    public void run() {
      //  synchronized (Lock){  //这样就永远只有一个窗口进来了;
        while (count > 0) {
        //我的理解: 当等于1 的时候,一下子进来五个 只有一个拿到了锁,然后他进去了,
        //变成了0,然后剩下四个一次进去 一次被阻塞,然后变成-1 -2 -3 -4
        //希望这段代码的执行过程中,不要有其他线程打扰
            synchronized (Lock) {
                if (count > 0) {
                    count--;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "买了一张票,还剩下 : " + count + "票");
                }
             }
         }
    }
}
