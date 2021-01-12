import actors.ActorA;
import actors.ActorB;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import util.Message;

public class RequestDontWaitForResponse {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("system");

        final ActorRef actorA = system.actorOf(ActorA.createActor());
        final ActorRef actorB = system.actorOf(ActorB.createActor());

        actorA.tell(new Message(actorB), ActorRef.noSender());

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
