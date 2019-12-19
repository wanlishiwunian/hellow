package demo1;

public class ThreadTest {
    public static void main(String[] args) {
//        PrintEven printEven = new PrintEven();
//        Thread thread = new Thread(printEven);
//        thread.start();
        MyThread myThread = new MyThread("0");
        MyThread myThread1 = new MyThread("1");
        MyThread myThread2 = new MyThread("2");
        MyThread myThread3 = new MyThread("3");
        myThread.start();
        myThread1.start();
        myThread2.start();
        myThread3.start();
       // System.out.println();
    }
}

class PrintEven implements Runnable{

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}

class MyThread extends Thread{

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run(){
        System.out.println("线程名称: "+ getName());
    }
}