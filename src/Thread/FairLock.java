package Thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by blue on 2016/3/25.
 * 公平锁
 */
public class FairLock implements Runnable {
    public static ReentrantLock fairLock = new ReentrantLock(true);
    @Override
    public void run() {
        while (true){
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName()+"获得锁");
            }finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FairLock r1 = new FairLock();
        Thread t1 = new Thread(r1,"Thread t1");
        Thread t2 = new Thread(r1,"Thread t2");
        t1.start();
        t2.start();
    }
}
