package actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.pattern.Patterns;
import akka.pattern.Patterns$;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;
import util.Message;
import util.Request;
import util.Response;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class ActorA extends UntypedAbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    ActorRef actorRef;
    static public Props createActor(){
        return Props.create(ActorA.class, ActorA::new );
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        System.out.println("Message type: "+ message.getClass().getName());

        if(message instanceof Message){
            actorRef = ((Message) message).getActorRef();
            Timeout timeout = Timeout.create(Duration.ofSeconds(5));
            Future<Object> future1 = Patterns.ask(actorRef, "req1", timeout);
            Response resp1 = (Response) Await.result(future1, timeout.duration());
            log.info("Data received: "+ resp1.getMessage());

            timeout = Timeout.create(Duration.ofSeconds(5));
            Future<Object> future2 = Patterns.ask(actorRef, "req2", timeout);
            Response resp2 = (Response) Await.result(future2, timeout.duration());
            log.info("Data received: "+ resp2.getMessage());

        }
    }
}
