package regular.actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import util.Message;
import util.Request;

public class ActorA extends UntypedAbstractActor {
    ActorRef actorRef1;
    ActorRef actorRef2;

    static public Props createActor(){
        return Props.create(ActorA.class, ActorA::new);
    }

    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        if (message instanceof Message) {
            actorRef1 = ((Message) message).getActorRef1();
            actorRef2 = ((Message) message).getActorRef2();

            actorRef1.tell(new Request(actorRef2, "req1"), getSelf());

        }
    }
}
