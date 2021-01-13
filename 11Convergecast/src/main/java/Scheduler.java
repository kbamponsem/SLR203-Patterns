import actors.*;
import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class Scheduler {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("system");
        final ActorRef actorA = system.actorOf(ActorA.createActor());
        final ActorRef actorB = system.actorOf(ActorB.createActor());
        final ActorRef actorC = system.actorOf(ActorC.createActor());
        final ActorRef actorD = system.actorOf(ActorD.createActor());
        final ActorRef merger = system.actorOf(Merger.createActor());

        actorA.tell(merger, ActorRef.noSender());
        actorB.tell(merger, ActorRef.noSender());
        actorC.tell(merger, ActorRef.noSender());
        merger.tell(actorD, ActorRef.noSender());
        merger.tell("join", actorB);
        merger.tell("join", actorC);
        merger.tell("join", actorA);
        try {
            waitBeforeTerminate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            system.terminate();
        }
    }

    public static void waitBeforeTerminate() throws InterruptedException {
        Thread.sleep(5000);
    }
}
