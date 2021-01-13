package actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import java.util.Arrays;
import java.util.Vector;

public class Merger extends UntypedAbstractActor {
    Vector<ActorRef> joinedList = new Vector<>();
    Vector<String> messages = new Vector<>();
    Vector<String> s_messages = new Vector<>();
    ActorRef actorD;
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    static public Props createActor() {
        return Props.create(Merger.class, Merger::new);
    }

    @Override
    public void onReceive(Object message) throws Throwable, Throwable {


        if (message instanceof String & message.equals("hi")) {
            messages.add((String) message);
            if (joinedList.size() == 3 && messages.size() == 3) {
                actorD.tell("hi", getSelf());
            }
        }

        if(message instanceof  String & message.equals("hi2")){

            s_messages.add((String) message);
            if(joinedList.size()==2 && s_messages.size() == 2 ){
                actorD.tell("hi2", getSelf());
            }

        }

        if (message instanceof String & message.equals("join")) {
            joinedList.add(getSender());
        }

        if(message instanceof  String & message.equals("unjoin")){
            joinedList.remove(getSender());
        }

        if (message instanceof ActorRef) {
            actorD = (ActorRef) message;
        }
    }
}
