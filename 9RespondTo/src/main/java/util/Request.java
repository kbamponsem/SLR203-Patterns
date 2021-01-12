package util;

import akka.actor.ActorRef;

public class Request {
    ActorRef ref;
    String message;
    public Request(ActorRef ref, String message){
        this.ref = ref;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public ActorRef getRef() {
        return ref;
    }
}
