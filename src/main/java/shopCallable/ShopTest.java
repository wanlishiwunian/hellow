package shopCallable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ShopTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        SimpleDateFormat sl = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        shopCallable s1 = new shopCallable();

        s1.setShopName("pdd");
        FutureTask<Double> f1 = new FutureTask<Double>(s1);
        new Thread(f1).start();

        s1.setShopName("jd");
        new Thread(f1).start();

        shopCallable s2 = new shopCallable();
        s2.setShopName("tbb");
        FutureTask<Double> f2 = new FutureTask<Double>(s2);
        new Thread(f2).start();
        Double price2 = f2.get();
        Double price = f1.get();
        System.out.println("价格是: "+price+"  "+sl.format(new Date()));

        System.out.println("价格是: "+price2+"  "+sl.format(new Date()));
    }
}
