package actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import messageTypes.MessageString;
import messageTypes.RefAndString;

public class Transmitter extends UntypedAbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    ActorRef actorRefB;
    String message;
    static public Props createActor(){
        return Props.create(Transmitter.class, ()->{return new Transmitter();});
    }

    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        if(message instanceof RefAndString){
            log.info("Transmitter received message from ({})", getSender().path().name());

            this.actorRefB = ((RefAndString) message).getRef();
            this.message = ((RefAndString) message).getMessage();
            this.actorRefB.tell(new MessageString(this.message), getSender());
        }
    }
}
