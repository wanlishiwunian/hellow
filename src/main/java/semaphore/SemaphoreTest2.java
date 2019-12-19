package semaphore;

public class SemaphoreTest2 {
    public static void main(String[] args) {

        SemaphoreService2 semaphoreService2 = new SemaphoreService2();

        for (int i = 0; i < 10; i++) {
            MyThread myThread = new MyThread("Thread < " + (i + 1)+" > ", semaphoreService2);
            myThread.start();
            System.out.println("可用的通路: "+semaphoreService2.availablePermits());
        }
    }
}
