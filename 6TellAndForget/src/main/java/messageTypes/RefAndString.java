package messageTypes;

import akka.actor.ActorRef;

public class RefAndString {
    ActorRef ref;
    String message;

    public RefAndString(ActorRef ref, String message){
        this.ref = ref;
        this.message = message;
    }

    public ActorRef getRef() {
        return ref;
    }

    public String getMessage() {
        return message;
    }
}
