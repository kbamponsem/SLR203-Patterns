import actors.ActorA;
import actors.ActorB;
import actors.ActorC;
import actors.Broadcaster;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import scala.concurrent.ExecutionContext;

import java.time.Duration;

public class Scheduler {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("system");
        final ActorRef actorA = system.actorOf(ActorA.createActor());
        final ActorRef actorB = system.actorOf(ActorB.createActor());
        final ActorRef actorC = system.actorOf(ActorC.createActor());
        final ActorRef broadcaster = system.actorOf(Broadcaster.createActor());

        actorA.tell(broadcaster, ActorRef.noSender());
        broadcaster.tell("join", actorB );
        broadcaster.tell("join", actorC);
        try {
            waitBeforeTerminate();
        } catch (Exception e) {

        } finally {
            system.terminate();
        }
    }

    public static void waitBeforeTerminate() throws InterruptedException {
        Thread.sleep(5000);
    }
}
