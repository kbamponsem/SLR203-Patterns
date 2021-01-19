package actors;

import akka.actor.ActorRef;
import akka.actor.UntypedAbstractActor;
import messages.Request;
import messages.Response;

public class Session extends UntypedAbstractActor {
    ActorRef sessionManager;
    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof Request) {
            System.out.println("Request received: " + ((Request) message).getMessage() + " from " + getSender().path().name());
            if( ((Request) message).getMessage().equals("m1")){
                getSender().tell(new Response("m2"), getSelf());
            }
        }
        if(message instanceof String){
            if(message.equals("stop")){
                sessionManager = getSender();
                getContext().stop(getSelf());

            }
        }
    }

    @Override
    public void postStop() throws Exception {

        super.postStop();
        sessionManager.tell(new Response("session-ended"), getSelf());
    }
}
