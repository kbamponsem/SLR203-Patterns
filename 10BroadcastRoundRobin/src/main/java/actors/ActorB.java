package actors;

import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class ActorB extends UntypedAbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    static public Props createActor() {
        return Props.create(ActorB.class, ActorB::new);
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof String){
            log.info("Data received: {} on {}", message, getSelf().path().name());
        }
    }
}
