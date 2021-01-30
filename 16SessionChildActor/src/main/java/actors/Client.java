package actors;

import akka.actor.ActorRef;
import akka.actor.UntypedAbstractActor;
import akka.pattern.Patterns;
import akka.util.Timeout;
import messages.ActorAndString;
import messages.Request;
import messages.Response;
import messages.Session;
import scala.concurrent.Await;
import scala.concurrent.Future;

import java.time.Duration;

public class Client extends UntypedAbstractActor {
    ActorRef sessionManager;
    ActorRef session;
    String response;

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof Session) {
            session = ((Session) message).getSession();
            sessionManager = getSender();
            session.tell(new Request("m1"), getSelf());
            session.tell(new Request("hello"), getSelf());
            session.tell(new Request("hi"), getSelf());
            session.tell(new Request("hesdflk i"), getSelf());
            session.tell(new Request("sdflkjfk"), getSelf());
        }
        if (message instanceof Response) {
            System.out.println("Response received: " + ((Response) message).getMessage() + " from " + getSender().path().name());
            sessionManager.tell("endSession", getSelf());
        }
    }
}
