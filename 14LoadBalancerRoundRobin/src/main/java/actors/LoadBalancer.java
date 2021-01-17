package actors;

import akka.actor.ActorRef;
import akka.actor.UntypedAbstractActor;

import java.util.Vector;

public class LoadBalancer extends UntypedAbstractActor {
    Vector<ActorRef> actors = new Vector<>();
    int round;
    @Override
    public void onReceive(Object message) throws Throwable {
        if(message instanceof String){
            if (message.equals("join")) {
                actors.add(getSender());
            } else if (message.equals("unjoin")) {
                actors.remove(getSender());
            }else{
                round = round % actors.size();
                actors.get(round).tell(message, getSender());
                round += 1;
            }
        }
    }
}
