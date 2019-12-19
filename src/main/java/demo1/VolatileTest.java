package demo1;

public class VolatileTest {
    public static void main(String[] args) {
        SportMan2 WuGui = new SportMan2("乌龟", 1000, 1000, 30);
        SportMan2 TuZhi = new SportMan2("兔子", 10000, 100, 30);
        WuGui.start();
        TuZhi.start();
        while(true){
            if (WuGui.getOver()==true || TuZhi.getOver()==true){
                WuGui.setStop(true);
                TuZhi.setStop(true);
                break;
            }
        }
        //宣布结果
        if(WuGui.getOver() && TuZhi.getOver()){
            System.out.println("平局");
        }else if (WuGui.getOver()){
            System.out.println( WuGui.getName()+"赢了");
        }else {
            System.out.println(TuZhi.getName()+"赢了");
        }
    }
}

class SportMan2 extends Thread {
    private String name;
    private int restTime;
    private int perMeter;
    private int distance;
    private Long time;
    private Boolean over; //判断是否已经跑完
    private Boolean stop; //判断是不是要停止跑步,因为有的人已经跑完了;

    public SportMan2(String name, int restTime, int perMeter, int distance) {
        super(name);
        this.restTime = restTime;
        this.perMeter = perMeter;
        this.distance = distance;
    }
    //设置不要再跑了
    public void setStop(Boolean stop) {
        this.stop = stop;
    }
    //看一看是不是跑完了
    public Boolean getOver() {
        return over;
    }
    @Override
    public void run() {
        for (int i = 1; i <= distance && !stop; i++) {
            long start = System.currentTimeMillis();
            System.out.println(name + "跑了第" + i + "米");
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
            if (i == distance) {
                over = true; //表示跑完了;
            }
            long end = System.currentTimeMillis();
        }
    }
}
