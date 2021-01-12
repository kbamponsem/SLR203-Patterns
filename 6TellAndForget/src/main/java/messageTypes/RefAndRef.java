package messageTypes;
import akka.actor.ActorRef;

public class RefAndRef {
    ActorRef ref1;
    ActorRef ref2;

    public RefAndRef(ActorRef ref1, ActorRef ref2){
        this.ref1 = ref1;
        this.ref2 = ref2;
    }

    public ActorRef getRef1(){
        return this.ref1;
    }
    public ActorRef getRef2(){
        return this.ref2;
    }
}
