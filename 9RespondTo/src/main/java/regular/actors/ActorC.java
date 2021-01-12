package regular.actors;

import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.pattern.Patterns;
import util.Response;

public class ActorC extends UntypedAbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    static public Props createActor() {
        return Props.create(ActorC.class, ActorC::new);
    }

    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        System.out.println(message.getClass().getName());
        if (message instanceof Response) {
            log.info("Message received: {}", ((Response) message).getMessage());
        }
    }
}
