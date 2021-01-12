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

import java.time.Duration;

public class ActorA extends UntypedAbstractActor {
    ActorRef actorRef1;
    ActorRef actorRef2;

    static public Props createActor(){
        return Props.create(ActorA.class, ActorA::new);
    }
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    @Override
    public void onReceive(Object message) throws Throwable, Throwable {

        if(message instanceof Message){
            log.info("Data received: {}, {}", ((Message) message).getActorRef1().path().name(), ((Message) message).getActorRef2().path().name());
            actorRef1 = ((Message) message).getActorRef1();
            actorRef2 = ((Message) message).getActorRef2();
            Timeout timeout = Timeout.create(Duration.ofSeconds(5));
            Future<Object> future = Patterns.ask(actorRef1, new Request(actorRef2, "req1"), timeout);

            Patterns.pipe(future, getContext().dispatcher());
        }
    }
}
