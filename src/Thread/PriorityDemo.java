package Thread;

/**
 * Created by blue on 2016/3/24.
 * 线程优先级
 */
public class PriorityDemo {
    public static class HighPriority extends Thread{
        static int count = 0;
        public void run(){
            while (true){
                synchronized (PriorityDemo.class){
                    count++;
                    if(count>100000){
                        System.out.println("HighPriority is complete");
                        break;
                    }
                }
            }
        }
    }

    public static class LowPriority extends Thread{
        static int count = 0;
        public void run(){
            while (true){
                synchronized (PriorityDemo.class){
                    count++;
                    if(count>100000){
                        System.out.println("LowPriority is complete");
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new HighPriority();
        Thread t2 = new LowPriority();
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t2.start();
        t1.start();

    }
}
