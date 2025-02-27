package piped.actors;

import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import util.Response;

public class ActorC extends UntypedAbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    static public Props createActor() {
        return Props.create(ActorC.class, ActorC::new);
    }

    @Override
    public void onReceive(Object message) throws Throwable, Throwable {

    }
}
