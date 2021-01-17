import actors.LoadBalancer;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import actors.Actor;

public class Main {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("system");
        final ActorRef actorA = system.actorOf(Props.create(Actor.class), "actorA");
        final ActorRef actorB = system.actorOf(Props.create(Actor.class), "actorB");
        final ActorRef actorC = system.actorOf(Props.create(Actor.class), "actorC");
        final ActorRef loadBalancer = system.actorOf(Props.create(LoadBalancer.class), "loadBalancer");

        loadBalancer.tell("join", actorB);
        loadBalancer.tell("join", actorC);

        loadBalancer.tell("m1", actorA);
        loadBalancer.tell("m2", actorA);
        loadBalancer.tell("m3", actorA);

        loadBalancer.tell("unjoin", actorC);
        loadBalancer.tell("m4", actorA);
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            system.terminate();
        }
    }
}
