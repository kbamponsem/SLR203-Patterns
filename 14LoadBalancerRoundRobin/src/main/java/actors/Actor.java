package actors;

import akka.actor.ActorRef;
import akka.actor.UntypedAbstractActor;

import java.util.Vector;

public class Actor extends UntypedAbstractActor {
    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof String) {

            System.out.println("Message " + message + " received from " + getSender().path().name() + " by " + getSelf().path().name());

        }
    }
}
