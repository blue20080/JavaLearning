package Thread.Akka;

import akka.actor.UntypedActor;
/**
 * Created by blue on 2016/4/1.
 */
public class Greeter extends UntypedActor {

    public static enum Msg{
        GREET,DONE;
    }

    @Override
    public void onReceive(Object msg) throws Exception {
        if(msg == Msg.GREET){
            System.out.println("hello world!");
            getSender().tell(Msg.DONE,getSelf());
        }else{
            unhandled(msg);
        }

    }
}
