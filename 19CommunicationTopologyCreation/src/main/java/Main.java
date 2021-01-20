import actors.Node;
import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        final ActorSystem system = ActorSystem.create("system");
        final ActorRef node1 = system.actorOf(Props.create(Node.class), "node1");
        final ActorRef node2 = system.actorOf(Props.create(Node.class), "node2");
        final ActorRef node3 = system.actorOf(Props.create(Node.class), "node3");
        final ActorRef node4 = system.actorOf(Props.create(Node.class), "node4");



        node1.tell(new ActorRef[]{node2, node3}, ActorRef.noSender());

        node2.tell(new ActorRef[]{node4}, ActorRef.noSender());

        node4.tell(new ActorRef[]{node1, node4}, ActorRef.noSender());

        node3.tell(new ActorRef[]{node3, node1}, ActorRef.noSender());

        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            system.terminate();
        }
    }
}
