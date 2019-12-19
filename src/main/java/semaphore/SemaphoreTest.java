package semaphore;


public class SemaphoreTest {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            SemaPhoreService semaPhoreService = new SemaPhoreService();
            MyThread myThread = new MyThread("Thread < "+(i+1)+" > ",semaPhoreService);
            myThread.start();
         //   System.out.println("可用通路数量: "+semaPhoreService.availablePermits());
        }
    }
}
