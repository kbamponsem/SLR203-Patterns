package actors;

import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import messageTypes.MessageString;

public class ActorB extends UntypedAbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    static public Props createActor(){
        return Props.create(ActorB.class, ()->{return new ActorB();});
    }
    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        if(message instanceof MessageString){
            log.info("Received message from ({})", getSender());

            getSender().tell("Hiii", getSelf());
        }
    }
}
