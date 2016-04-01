package Thread.Concurrent;

/**
 * Created by blue on 2016/3/24.
 * Ïß³ÌInterrupt
 */
public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
        public void run(){
                while (true){
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Tnterruted!");
                        break;
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("Tnterruted When Sleep!");
                        Thread.currentThread().interrupt();
                    }

                    Thread.yield();
                }
            };
        };

        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }
}
