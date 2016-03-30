package Thread.model.Future;

/**
 * Created by blue on 2016/3/30.
 */
public class Client {
    public Data request(final String queryStr){
        final FutureData future = new FutureData();
        new Thread(){
            public void run(){
                RealData realData = new RealData(queryStr);
                future.setRealdata(realData);
            }
        }.start();
        return future;
    }
}
