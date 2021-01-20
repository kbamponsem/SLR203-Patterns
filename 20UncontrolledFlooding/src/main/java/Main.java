import actors.Node;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {
    public static void main(String[] args) {

        final ActorSystem system = ActorSystem.create("system");
        final ActorRef nodeA = system.actorOf(Props.create(Node.class), "A");
        final ActorRef nodeB = system.actorOf(Props.create(Node.class), "B");
        final ActorRef nodeC = system.actorOf(Props.create(Node.class), "C");
        final ActorRef nodeD = system.actorOf(Props.create(Node.class), "D");
        final ActorRef nodeE = system.actorOf(Props.create(Node.class), "E");



        nodeA.tell(new ActorRef[]{nodeB, nodeC}, ActorRef.noSender());

        nodeB.tell(new ActorRef[]{nodeD}, ActorRef.noSender());

        nodeC.tell(new ActorRef[]{nodeD}, ActorRef.noSender());

        nodeD.tell(new ActorRef[]{nodeE}, ActorRef.noSender());

        nodeE.tell(new ActorRef[]{}, ActorRef.noSender()); // -- finite cycle
        //nodeE.tell(new ActorRef[]{}, ActorRef.noSender()); // -- infinite cycle

        // we start the algorithm
        nodeA.tell("hello", ActorRef.noSender());
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
