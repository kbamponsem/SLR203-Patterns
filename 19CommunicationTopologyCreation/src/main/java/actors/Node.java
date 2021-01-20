package actors;

import akka.actor.ActorRef;
import akka.actor.UntypedAbstractActor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class Node extends UntypedAbstractActor {
    ActorRef[] neighbors;
    @Override
    public void onReceive(Object message) throws Throwable {
        if(message instanceof ActorRef[]){
            neighbors = (ActorRef[]) message;

            for(ActorRef ref : neighbors){
                System.out.println(getSelf().path().name()+" has reference to "+ref.path().name());
            }
        }
    }
}
