package util;

import akka.actor.ActorRef;

public class Message {
    ActorRef actorRef;
    public Message(ActorRef actorRef){
        this.actorRef = actorRef;
    }

    public ActorRef getActorRef() {
        return actorRef;
    }
}
