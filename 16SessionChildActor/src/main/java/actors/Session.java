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

            getSender().tell(new Response(((Request) message).getMessage().toUpperCase()), getSelf());

        }
        if (message instanceof String) {
            if (message.equals("stop")) {
                sessionManager = getSender();
                getContext().stop(getSelf());

            }
        }
    }

    @Override
    public void postStop() throws Exception {

        super.postStop();
        getContext().getSender().tell(new Response("session-ended"), getSelf());
    }
}
