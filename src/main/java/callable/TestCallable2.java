package callable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class TestCallable2 {

    private static SimpleDateFormat sl = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getTime() {
        return sl.format(new Date());
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);


        Callable<String> myCallable = new Callable() {
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                System.out.println("call方法执行了");
                return "call方法返回值";
            }
        };

        System.out.println("提交任务前: "+getTime());
        Future<String> submit = executorService.submit(myCallable);
        System.out.println("提交任务后,结果获取前: "+getTime());
        try {
       /*     Thread.sleep(4000);
            System.out.println("已经睡了4秒: "+getTime());*/
            System.out.println("拿结果: "+submit.get()+getTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("结果获取后: "+getTime());

    }

}
