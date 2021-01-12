package actors;

import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import scala.concurrent.Future;
import util.Response;

import java.util.concurrent.TimeUnit;

public class ActorB extends UntypedAbstractActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    static public Props createActor(){return Props.create(ActorB.class, ActorB::new);}

    @Override
    public void onReceive(Object message) throws Throwable {
        System.out.println("Message type: "+ message.getClass().getName());
        if (message instanceof String) {
            if(message.equals("req1")){

                getSender().tell(new Response("response", "res1"), getSelf());
            }
            else if (message.equals("req2")){
                getSender().tell(new Response("response", "res2"), getSelf());
            }
        }
    }
}
