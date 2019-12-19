package demo1;

public class TestJoin {
    public static void main(String[] args) {

        Myjoin myjoin1 = new Myjoin("1号线程");
        myjoin1.start();
        Myjoin myjoin2 = new Myjoin("2号线程");
        myjoin2.start();

        for (int i = 1; i <= 10; i++) {
            if (i == 2) {
                try {
                    myjoin1.join(); //这里是分线程进入,然后主线程被加塞了,主线程成了阻塞状态;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "打印的是: " + i);
        }
    }
}
class Myjoin extends Thread {
    public Myjoin(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程,打印的是: " + i);
        }
    }
}