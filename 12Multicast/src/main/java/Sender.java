import actors.Receiver2;
import actors.Receiver3;
import util.Message;
import actors.Multicast;
import actors.Receiver1;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class Sender {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("system");
        final ActorRef receiver1 = system.actorOf(Receiver1.createActor());
        final ActorRef receiver2 = system.actorOf(Receiver2.createActor());
        final ActorRef receiver3 = system.actorOf(Receiver3.createActor());
        final ActorRef multicast = system.actorOf(Multicast.createActor());

        multicast.tell(new Message("group1", new ActorRef[]{receiver1, receiver2}), ActorRef.noSender());
        multicast.tell(new Message("group2", new ActorRef[]{receiver2, receiver3}), ActorRef.noSender());
        multicast.tell("group1", ActorRef.noSender());
        multicast.tell("group2", multicast);
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            system.terminate();
        }
    }
}
