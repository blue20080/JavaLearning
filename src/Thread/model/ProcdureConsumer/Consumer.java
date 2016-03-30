package Thread.model.ProcdureConsumer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * Created by blue on 2016/3/30.
 */
public class Consumer implements Runnable{
    private BlockingQueue<PCData> queue;
    private static final int SLEEPTIME=1000;

    public Consumer(BlockingQueue<PCData> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        Random r = new Random();
        System.out.println("start Consumer id="+Thread.currentThread().getId());

        try {
            while (true){
                PCData data = queue.take();
                if(null != data){
                    int re = data.getData() * data.getData();
                    System.out.println(MessageFormat.format("{0}*{1}={2}",data.getData(),data.getData(),re));
                    Thread.sleep(r.nextInt(SLEEPTIME));
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
