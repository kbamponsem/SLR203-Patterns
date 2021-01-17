package actors;

import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

public class Publisher extends UntypedAbstractActor {
    Topic[] topics;

     static public Props createPublisher() {
        return Props.create(Publisher.class, Publisher::new);
    }



    @Override
    public void onReceive(Object message) throws Throwable {
        if(message instanceof Topic){
                System.out.println("topics: "+((Topic) message).getSender().path().name());
        }
    }
}
