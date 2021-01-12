package piped.actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Future;
import util.Message;
import util.Request;
import util.Response;

import java.time.Duration;

public class ActorB extends UntypedAbstractActor {
    ActorRef ref;
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    static public Props createActor() {
        return Props.create(ActorB.class, ActorB::new);
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        System.out.println(message.getClass().getName());

        if(message instanceof Request){
            log.info("ActorRef {} received.", ((Request) message).getRef().path().name());
            ref = ((Request) message).getRef();

            Timeout timeout = Timeout.create(Duration.ofSeconds(5));
            Future<Object> future = Patterns.ask(ref, new Response("res1"), timeout);

            Patterns.pipe(future, getContext().dispatcher());
        }
    }
}
