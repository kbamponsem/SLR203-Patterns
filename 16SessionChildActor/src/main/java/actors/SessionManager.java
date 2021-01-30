package actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import messages.ActorAndString;
import messages.Response;
import messages.Session;

import java.util.HashMap;

public class SessionManager extends UntypedAbstractActor {
    HashMap<ActorRef, Session> clientSession = new HashMap<>();
    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof String){
            if(message.equals("createSession")){

                long sessionId = System.nanoTime();
                Session session = new Session(getContext().getSystem().actorOf(Props.create(actors.Session.class), "session"+sessionId), getSender(), "session1");
                System.out.println("Session created for " + getSender().path().name() + " with sessionId " + sessionId);
                clientSession.put(getSender(), session);
                getSender().tell(session, getSelf());
            }
            else if (message.equals("endSession")){
                clientSession.get(getSender()).getSession().tell("stop", getSelf());

            }
        }
        if(message instanceof Response){
            System.out.println(((Response) message).getMessage()+" received from "+getSender().path().name());
        }
    }
}
