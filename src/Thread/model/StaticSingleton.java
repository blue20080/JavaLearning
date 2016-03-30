package Thread.model;

/**线程的设计模式
 * Created by blue on 2016/3/30.
 */
public class StaticSingleton {
    private StaticSingleton(){
        System.out.println("StaticSingleton is create");
    }
    private static class SingletonHolder{
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstatnce(){
        return SingletonHolder.instance;
    }

    public static void main(String[] args){
        StaticSingleton instance = getInstatnce();
    }
}
