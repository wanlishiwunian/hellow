package juc;

public class Phone {
    public synchronized void sendEmail()  {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发送邮件");
        sendMsg();
    }
    
    public synchronized void sendMsg(){
        System.out.println("发送短信");
    }


    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone1 = new Phone();
        //一边发邮件
        new Thread(()-> {
            phone.sendEmail();
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //一边发短信;
        new Thread(new Runnable() {
                @Override
                public void run() {
                    phone.sendMsg();
                }
            }).start();
    }
}
