package actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

import java.util.HashMap;
import java.util.Vector;

public class Topic extends UntypedAbstractActor {
    Vector<ActorRef> subscribers = new Vector<>();

    static public Props createTopic() {
        return Props.create(Topic.class, Topic::new);
    }


    @Override
    public void onReceive(Object message) throws Throwable {
        String topicName = getSelf().path().name();
        if (message instanceof String) {
            System.out.println("Message " + message + " from " + getSender().path().name() + " on "+topicName);
            if( message.equals("subscribe")){
                subscribers.add(getSender());
            }
            else if (message.equals("unsubscribe")) {
                subscribers.remove(getSender());
            }else{
                for (ActorRef subscriber : subscribers) {
                    subscriber.tell(message, getSelf());
                }
            }
        }
    }
}
