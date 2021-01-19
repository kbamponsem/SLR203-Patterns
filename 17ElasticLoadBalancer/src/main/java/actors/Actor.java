package actors;

import akka.actor.ActorRef;
import akka.actor.UntypedAbstractActor;
import messages.Request;
import messages.Response;

public class Actor extends UntypedAbstractActor {
    ActorRef loadBalancer;

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof ActorRef) {
            loadBalancer = (ActorRef) message;
        }
        if(message instanceof Request){
            loadBalancer = getSender();
            System.out.println("Message: "+ ((Request) message).getMessage()+ " received by "+ getSelf().path().name());
            getSender().tell(new Response(((Request) message).getMessage(), "finished"), getSelf());
        }

    }

    @Override
    public void postStop() throws Exception {
        System.out.println("Actor "+ getSelf().path().name()+ " stopped!😘");
    }
}
