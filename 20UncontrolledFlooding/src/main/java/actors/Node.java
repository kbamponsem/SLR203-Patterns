package actors;

import akka.actor.ActorRef;
import akka.actor.UntypedAbstractActor;

public class Node extends UntypedAbstractActor {
    ActorRef[] neighbors;
    int sequenceNumber = -1;
    @Override
    public void onReceive(Object message) throws Throwable {
        if(message instanceof ActorRef[]){
            neighbors = (ActorRef[]) message;
        }

        if(message instanceof String){
            System.out.println("messages.Message:-> " +message+" from "+
                    getSender().path().name() +" received by "+
                    getSelf().path().name());
            //forward message to all neighbors
            for(ActorRef ref: neighbors){
                ref.tell(message, getSelf());
            }
        }
    }
}
