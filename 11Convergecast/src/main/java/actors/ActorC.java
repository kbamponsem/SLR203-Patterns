package actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.RepointableActorRef;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import java.time.Duration;

public class ActorC extends UntypedAbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    RepointableActorRef merger;

    static public Props createActor() {
        return Props.create(ActorC.class, ActorC::new);
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if(message instanceof String & message.equals("go")){
            merger.tell("hi", getSelf());
            merger.tell("unjoin", getSelf());
        }

        if(message instanceof RepointableActorRef){
            getContext().system().scheduler().scheduleOnce(Duration.ofMillis(1000), getSelf(), "go", getContext().getSystem().getDispatcher(), ActorRef.noSender());
            merger = (RepointableActorRef) message;
        }
    }

}
