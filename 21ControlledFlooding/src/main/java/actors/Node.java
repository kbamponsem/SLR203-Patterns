package actors;

import akka.actor.ActorRef;
import akka.actor.UntypedAbstractActor;
import messages.Message;

public class Node extends UntypedAbstractActor {
    ActorRef[] neighbors;
    int sequenceNumber = -1;
    @Override
    public void onReceive(Object message) throws Throwable {
        if(message instanceof ActorRef[]){
            neighbors = (ActorRef[]) message;
        }

        if (message instanceof String) {
            if(message.equals("START")){
                for(ActorRef ref: neighbors){
                    ref.tell(new Message("hello", 0), getSelf());
                }
            }else{

            }
        }

        if(message instanceof Message){
            System.out.println("Message:-> " + ((Message) message).getMessage() + " with seqNum:->" +((Message) message).getSequnceNumber()+
                    " from " + getSender().path().name() + " received by " +
                    getSelf().path().name());

            for (ActorRef ref : neighbors) {

                if (sequenceNumber == ((Message) message).getSequnceNumber()) {
                    System.out.println("Message dropped at " + getSelf().path().name());
                } else {
                    sequenceNumber = ((Message) message).getSequnceNumber();
                    ref.tell(message, getSelf());

                }
            }
        }
    }
}
