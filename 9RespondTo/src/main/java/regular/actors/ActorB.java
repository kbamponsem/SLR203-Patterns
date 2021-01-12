package regular.actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import util.Request;
import util.Response;

public class ActorB extends UntypedAbstractActor {
    ActorRef ref;
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    static public Props createActor() {
        return Props.create(ActorB.class, ActorB::new);
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof Request) {
            ref = ((Request) message).getRef();
            if (((Request) message).getMessage().equals("req1")) {
                ref.tell(new Response("res1"), getSelf());
                log.info("Message received: {}", ((Request) message).getMessage());

            }
        }
    }
}
