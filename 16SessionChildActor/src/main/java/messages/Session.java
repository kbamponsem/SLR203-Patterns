package messages;

import akka.actor.ActorRef;

public class Session {
    ActorRef session;
    ActorRef client;
    String sessionId;

    public Session(ActorRef session, ActorRef client, String sessionId) {
        this.session = session;
        this.client = client;
        this.sessionId = sessionId;
    }

    public ActorRef getClient() {
        return client;
    }

    public String getSessionId() {
        return sessionId;
    }

    public ActorRef getSession() {
        return session;
    }
}
