package actors;

import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import util.Request;
import util.Response;

public class ActorB extends UntypedAbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    static public Props createActor(){
        return Props.create(ActorB.class, ActorB::new);
    }
    @Override
    public void onReceive(Object message) throws Throwable {
        if(message instanceof Request){
            if(((Request) message).getMessage().equals("req1")){
                log.info("Message received: {} from {}",((Request) message).getMessage(), getSender().path().name() );
                getSender().tell(new Response("response", getSelf().path().name(), "res1"), getSelf());
            }
            if(((Request) message).getMessage().equals("req2")){
                log.info("Message received: {} from {}",((Request) message).getMessage(), getSender().path().name() );
                getSender().tell(new Response("response", getSelf().path().name(), "res2"), getSelf());
            }
        }
    }
}
