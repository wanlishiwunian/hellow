package semaphore;

public class SemaphoreTest3 {
    public static void main(String[] args) {
        SemaphoreService3 semaphoreService3 = new SemaphoreService3();
        for (int i = 0; i < 10; i++) {
            MyThread myThread = new MyThread("Thread < " + (i + 1) + " > ", semaphoreService3);
            myThread.start();
        }

    }
}
