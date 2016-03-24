package Thread;

/**
 * Created by blue on 2016/3/24.
 * synchronized
 */
public class AccountingVol implements Runnable{
    static AccountingVol instance = new AccountingVol();
    static int i = 0;
    @Override
    public void run() {
        for(int j=0;j<1000000000;j++){
           synchronized (instance){
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1  = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
