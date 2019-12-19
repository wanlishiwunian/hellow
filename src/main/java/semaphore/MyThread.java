package semaphore;

public class MyThread extends Thread{

    private SemaPhoreService semaPhoreService;
    private SemaphoreService2 semaPhoreService2;
    private SemaphoreService3 semaPhoreService3;

    public MyThread(String name, SemaPhoreService semaPhoreService) {
        super(name);
        this.semaPhoreService = semaPhoreService;
    }

    public MyThread(String name, SemaphoreService2 semaPhoreService2) {
        super(name);
        this.semaPhoreService2 = semaPhoreService2;
    }

    public MyThread(String name, SemaphoreService3 semaPhoreService3) {
        super(name);
        this.semaPhoreService3 = semaPhoreService3;
    }

    @Override
    public void run() {
        semaPhoreService.doSomething();
    }
}
