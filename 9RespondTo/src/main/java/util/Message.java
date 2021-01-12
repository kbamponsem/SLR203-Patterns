package util;

import akka.actor.ActorRef;

public class Message {
    ActorRef actorRef1;
    ActorRef actorRef2;

    public Message(ActorRef actorRef1, ActorRef actorRef2){
        this.actorRef1 = actorRef1;
        this.actorRef2 = actorRef2;
    }

    public ActorRef getActorRef1() {
        return actorRef1;
    }

    public ActorRef getActorRef2() {
        return actorRef2;
    }
}
