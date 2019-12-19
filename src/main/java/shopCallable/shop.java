package shopCallable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class shop {
    private static SimpleDateFormat sl = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String getTime(){
        return sl.format(new Date());
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Double getPddPrice(){
        System.out.println("查询价格中PDD..."+getTime());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 200d;
    }
    public Double getTbPrice(){
        System.out.println("查询价格中TBB..."+getTime());
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 600d;
    }
    public Double getJDPrice(){
        System.out.println("查询价格中JDD..."+getTime());
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 800d;
    }

}
