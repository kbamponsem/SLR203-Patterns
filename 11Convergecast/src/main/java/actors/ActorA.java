package actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.RepointableActorRef;
import akka.actor.UntypedAbstractActor;

import java.time.Duration;

public class ActorA extends UntypedAbstractActor {
    RepointableActorRef merger;
    int count = 0;

    static public Props createActor() {

        return Props.create(ActorA.class, ActorA::new);
    }

    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        if (message instanceof String & message.equals("go")) {
                merger.tell("hi", getSelf());
                merger.tell("hi2", getSelf());
        }
        if (message instanceof RepointableActorRef) {
            getContext().system().scheduler().scheduleOnce(Duration.ofMillis(1000), getSelf(), "go", getContext().getSystem().getDispatcher(), ActorRef.noSender());
            merger = (RepointableActorRef) message;
        }
    }

}
