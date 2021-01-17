package actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import util.Message;

import java.time.Duration;
import java.util.Arrays;
import java.util.Vector;

public class Multicast extends UntypedAbstractActor {

    String group;
    Vector<ActorRef[]> members = new Vector<>();

    static public Props createActor() {
        return Props.create(Multicast.class, Multicast::new);
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof Message) {
            System.out.println(((Message) message).getMembers().length);
            members.add(((Message) message).getMembers());
        }

        if (message instanceof String) {
            if (message.equals("group1")) {
                for (ActorRef actorRef : members.get(0)) {
                    actorRef.tell("hello", getSelf());
                }
            } else {
                for (ActorRef actorRef : members.get(1)) {
                    actorRef.tell("world", getSelf());
                }
            }
        }
    }
}
