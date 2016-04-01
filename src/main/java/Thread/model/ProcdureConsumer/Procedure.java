package Thread.model.ProcdureConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by blue on 2016/3/30.
 */
public class Procedure implements Runnable {
    private volatile boolean isRunning = true;
    private BlockingQueue<PCData> queue;  //data sharing queue
    private static AtomicInteger count = new AtomicInteger();//count
    private static final int SLEEPTIME=1000;

    public Procedure(BlockingQueue<PCData> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        PCData data = null;
        Random r = new Random();
        System.out.println("start producer id="+Thread.currentThread().getId());
        try {
            while (isRunning){
                Thread.sleep(r.nextInt(SLEEPTIME));
                data = new PCData(count.incrementAndGet());
                System.out.println(data+" is put into queue");
                if(!queue.offer(data,2, TimeUnit.SECONDS)){
                    System.err.println("failed to put data:"+data);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop(){
        isRunning = false;
    }
}
