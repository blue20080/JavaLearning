package Thread.model.ProcdureConsumer;

import java.util.concurrent.*;

/**
 * Created by blue on 2016/3/30.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<PCData> queue = new LinkedBlockingQueue<PCData>(10);
        Procedure procedure1 = new Procedure(queue);
        Procedure procedure2 = new Procedure(queue);
        Procedure procedure3 = new Procedure(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(procedure1);
        service.execute(procedure2);
        service.execute(procedure3);
        service.execute(consumer1);
        service.execute(consumer2);
        service.execute(consumer3);
        Thread.sleep(10 * 1000);
        procedure1.stop();
        procedure2.stop();
        procedure3.stop();
        Thread.sleep(3000);
        service.shutdown();

    }
}
