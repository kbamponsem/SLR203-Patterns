package actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.RepointableActorRef;
import akka.actor.UntypedAbstractActor;
import scala.concurrent.ExecutionContext;

import java.time.Duration;

public class ActorA extends UntypedAbstractActor {
    RepointableActorRef ref;

    static public Props createActor() {

        return Props.create(ActorA.class, ActorA::new);
    }

    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        System.out.println("Type: " + message.getClass().getName() + "\tMsg: "+ message);
        if (message instanceof String) {
            if (message.equals("go")) {
                ref.tell("message", getSelf());
            }
        }else if(message instanceof RepointableActorRef){
            getContext().system().scheduler().scheduleOnce(Duration.ofMillis(1000), getSelf(), "go", getContext().getSystem().getDispatcher(), ActorRef.noSender());
            ref = (RepointableActorRef) message;
        }
    }

}
