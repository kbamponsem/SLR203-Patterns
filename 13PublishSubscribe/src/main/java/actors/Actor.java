package actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;

public class Actor extends UntypedAbstractActor {

    static public Props createActor(){
        return Props.create(Actor.class, Actor::new);
    }
    @Override
    public void onReceive(Object message) throws Throwable {
        if(message instanceof String){
            System.out.println("Message received: "+ message + " by "+getSelf().path().name());
        }
    }
}
