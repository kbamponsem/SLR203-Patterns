package actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.RepointableActorRef;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import java.time.Duration;

public class ActorD extends UntypedAbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    RepointableActorRef merger;

    static public Props createActor() {
        return Props.create(ActorD.class, ActorD::new);
    }

    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        if(message instanceof String & message.equals("go")){
            merger.tell("hi", getSelf());
        }
        if(message instanceof String){
            log.info("Data received: {} from {}", message, getSender().path().name());
        }
        if (message instanceof RepointableActorRef) {
            getContext().system().scheduler().scheduleOnce(Duration.ofMillis(1000), getSelf(), "go", getContext().getSystem().getDispatcher(), ActorRef.noSender());
            merger = (RepointableActorRef) message;
        }
    }
}
