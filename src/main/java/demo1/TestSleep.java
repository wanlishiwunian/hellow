package demo1;

public class TestSleep {
    public static void main(String[] args) {
        MySleep mySleep = new MySleep("非main线程");
        mySleep.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"打印的是: "+ i);
        }
    }
}

class MySleep extends Thread{
    public MySleep(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"打印的是: "+i);
        }
    }
}