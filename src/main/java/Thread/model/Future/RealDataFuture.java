package Thread.model.Future;

import java.util.concurrent.Callable;

/**
 * Created by blue on 2016/3/30.
 */
public class RealDataFuture implements Callable {
    private String para;
    public RealDataFuture(String para) {
        this.para = para;
    }


    @Override
    public Object call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<10;i++){
            sb.append(para);
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
