package shopCallable;

import java.util.concurrent.Callable;

public class shopCallable implements Callable<Double>{

    private String shopName;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public Double call() throws Exception {
        shop shop1 = new shop();
        Double price = 0d;
        if (shopName.equals("pdd")){
            price =  shop1.getPddPrice();
        }
        if (shopName.equals("tbb")){
            price =   shop1.getTbPrice();
        }
        if (shopName.equals("jdd")){
            price = shop1.getJDPrice();
        }
        return price;
    }
}
