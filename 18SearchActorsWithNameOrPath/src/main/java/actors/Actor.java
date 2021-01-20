package actors;

import akka.actor.ActorPath;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

import java.util.Vector;

public class Actor extends UntypedAbstractActor {
    int count = 1;
    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof String) {
            if (message.equals("CREATE")) {
                getContext().getSystem().actorOf(Props.create(ChildActor.class), "actor"+count);
                count++;
            }
            if(getSelf().path().name().equals("searcher")){

                System.out.println(getContext().actorSelection((String) message).pathString());
            }
            if(getSelf().path().name().equals("displayer") && message.equals("display")){
                getContext().getSystem();
            }
        }
    }
}
