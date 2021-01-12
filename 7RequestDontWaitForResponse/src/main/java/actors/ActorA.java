package actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import util.Message;
import util.Request;
import util.Response;

public class ActorA extends UntypedAbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    static public Props createActor() {
        return Props.create(ActorA.class, () -> new ActorA());
    }

    @Override
    public void onReceive(Object message) throws Throwable, Throwable {

        if (message instanceof Message) {
            Request req1 = new Request("request", getSelf().path().name(), "req1");
            Request req2 = new Request("request", getSelf().path().name(), "req2");

            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
            ((Message) message).getActorRef().tell(req1, getSelf());
            ((Message) message).getActorRef().tell(req2, getSelf());
        }
        if (message instanceof Response) {
            log.info("Message received: {} from {}", ((Response) message).getMessage(), ((Response) message).getSender());
        }
    }
}

