import actors.ActorA;
import actors.ActorB;
import actors.Transmitter;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import messageTypes.MessageString;
import messageTypes.RefAndRef;

public class TellAndForgetMain {
    public static void main(String[] args) {

        final ActorSystem system = ActorSystem.create("system");
        final LoggingAdapter log = Logging.getLogger(system, "main");

        final ActorRef actorA = system.actorOf(ActorA.createActor(), "a");
        final ActorRef actorB = system.actorOf(ActorB.createActor(), "b");
        final ActorRef transmitter = system.actorOf(Transmitter.createActor(), "transmitter");

        RefAndRef message1 = new RefAndRef(transmitter, actorB);
        MessageString message2 = new MessageString("start");

        actorA.tell(message1, ActorRef.noSender());
        actorA.tell(message2, ActorRef.noSender());

        try {
            waitBeforeTerminate();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            system.terminate();
        }

    }

    public static void waitBeforeTerminate() throws InterruptedException {
        Thread.sleep(5000);
    }

}
