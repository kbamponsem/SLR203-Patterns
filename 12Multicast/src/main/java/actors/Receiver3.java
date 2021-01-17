package actors;

import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Receiver3 extends UntypedAbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    static public Props createActor() {
        return Props.create(Receiver1.class, Receiver1::new);
    }

    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        if (message instanceof String) {
            log.info("{} Data received {} from {}",getSelf().path().name(), message, getSender().path().name());
        }
    }
}
