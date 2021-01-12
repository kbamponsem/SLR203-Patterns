package actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import messageTypes.MessageString;
import messageTypes.RefAndRef;
import messageTypes.RefAndString;

public class ActorA extends UntypedAbstractActor {

    String message;
    ActorRef actorRefB;
    ActorRef transmitter;
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    static public Props createActor(){
        return Props.create(ActorA.class, ()-> new ActorA());
    }
    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        if(message instanceof RefAndRef){
            log.info("Received message from ({})", getSender().path().name());

            actorRefB = ((RefAndRef) message).getRef2();
            transmitter = ((RefAndRef) message).getRef1();
        }
        if(message instanceof String){
            log.info("Message received: ({})", message);
        }
        if(message instanceof MessageString){
            log.info("Message received: ({})", ((MessageString) message).getMessage());
            // then we start sending info the transmitter.
            transmitter.tell(new RefAndString(actorRefB, "hello"), getSelf());
        }


    }
}
