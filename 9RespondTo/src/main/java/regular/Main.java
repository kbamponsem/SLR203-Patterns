package regular;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import regular.actors.ActorA;
import regular.actors.ActorB;
import regular.actors.ActorC;

import util.Message;

public class Main {
    public static void main(String[] args) {
        final ActorSystem system1 = ActorSystem.create("system1");

        final ActorRef actorA = system1.actorOf(ActorA.createActor());
        final ActorRef actorB = system1.actorOf(ActorB.createActor());
        final ActorRef actorC = system1.actorOf(ActorC.createActor());

        actorA.tell(new Message(actorB, actorC), ActorRef.noSender());


        final ActorSystem system2 = ActorSystem.create("system2");

        final ActorRef _actorA = system2.actorOf(piped.actors.ActorA.createActor());
        final ActorRef _actorB = system2.actorOf(piped.actors.ActorB.createActor());
        final ActorRef _actorC = system2.actorOf(piped.actors.ActorC.createActor());

        _actorA.tell(new Message(_actorB, _actorC), ActorRef.noSender());
        try{
            waitBeforeTerminate();
        }catch (Exception e){

        }finally {
            system1.terminate();
            system2.terminate();
        }
    }

    public static void waitBeforeTerminate() throws InterruptedException {
        Thread.sleep(5000);
    }
}
