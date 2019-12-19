package demo1;

public class WuguiTest {
    public static void main(String[] args) {

        SportMan wuGui = new SportMan("乌龟", 30, 1000, 1000);
        SportMan tuZhi = new SportMan("兔子", 30, 10000, 100);
        wuGui.start();
        tuZhi.start();
        //等两个线程走完之后再公布结果,那就是兔子和乌龟都需要加塞在主线程前面
        try {
            tuZhi.join();
            wuGui.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //等两个线程执行完才能走这个方法;
        if (wuGui.getTime() < tuZhi.getTime()) {
            System.out.println(wuGui.getName() + "赢了");
        } else if (wuGui.getTime() > tuZhi.getTime()) {
            System.out.println(wuGui.getName() + "赢了");
        } else {
            System.out.println("平局");
        }
    }
}

class SportMan extends Thread {

    private String name;
    private int distance;
    private int restTime;
    private int perMeter;
    private Long time;

    public SportMan(String name) {
        this.name = name;
    }

    public SportMan(String name, int distance, int restTime, int perMeter) {
        super(name);
        this.name = name;
        this.distance = distance;
        this.restTime = restTime;
        this.perMeter = perMeter;
    }

    public Long getTime() {
        return time;
    }

    @Override
    public void run() {
        for (int i = 1; i <= distance; i++) {
            long start = System.currentTimeMillis();

            System.out.println(name + "跑了" + i + "米");
            try {
                Thread.sleep(perMeter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i % 10 == 0 && i != distance) {
                try {
                    Thread.sleep(restTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            long end = System.currentTimeMillis();
            time = end - start;
        }
    }
}
/*
class WuGui extends Thread{
    private Long time;
    public WuGui(String name) {
        super(name);
    }

    @Override
    public void run() {
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"跑了"+i);

            if(i ==10 || i==20){
                System.out.println(Thread.currentThread().getName()+"正在休息中,这是第"+i+"秒");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Long end = System.currentTimeMillis();
        time = end - start;
    }

    public Long getTime() {
        return time;
    }
}

class TuZhi extends Thread{
    private Long time;

    public Long getTime() {
        return time;
    }

    public TuZhi(String name) {
        super(name);
    }

    @Override
    public void run() {
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 30; i++) {
            System.out.println(Thread.currentThread().getName()+"跑了"+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i==10||i==20){
                System.out.println(Thread.currentThread().getName()+"正在休息中,这是第"+i + "秒");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Long end = System.currentTimeMillis();
        time = end-start;

    }
}
*/


