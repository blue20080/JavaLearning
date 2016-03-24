import java.util.ArrayList;
import java.util.List;

/**
 * Created by blue on 16/3/5.
 */
public class OOMObject {
    static class OOMObjectTest{
        public byte[] placeholder = new byte[64 * 1024];
    }

    public  static void fillHeap(int num) throws InterruptedException{
        List<OOMObjectTest> list = new ArrayList<OOMObjectTest>();
        for (int i = 0;i < num; i++){
            Thread.sleep(50);
            list.add(new OOMObjectTest());
            System.out.println("add!");
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception{
        fillHeap(1000);
    }

}
