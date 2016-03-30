package Thread.Concurrent;

import java.util.concurrent.*;

/**
 * Created by zhangyi on 2016/3/29.
 */
public class DivTask implements Runnable {
    int a,b;
    public DivTask(int a,int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        double re = a/b;
        System.out.println(re);
    }

    public static void main(String[] args) throws InterruptedException,ExecutionException{
        ThreadPoolExecutor pools = new ThreadPoolExecutor(0,Integer.MAX_VALUE,0L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        for(int i=0;i<5;i++){
           // pools.submit(new DivTask(100,i));
            Future re = pools.submit(new  DivTask(100,i));
            re.get();
        }
    }
}
