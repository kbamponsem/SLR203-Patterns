package messages;

import akka.actor.ActorRef;

public class ActorAndString {
    ActorRef actorRef;
    String message;
    Session session;
    public ActorAndString(ActorRef actorRef, String message) {
        this.actorRef = actorRef;
        this.message = message;
    }

    public ActorAndString(ActorRef actorRef, String message, Session session) {
        this.actorRef = actorRef;
        this.message = message;
        this.session = session;
    }
    public ActorRef getActorRef() {
        return actorRef;
    }

    public String getMessage() {
        return message;
    }

    public Session getSession() {
        return session;
    }
}
