import actors.Actor;
import actors.LoadBalancer;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("system");

        final ActorRef main = system.actorOf(Props.create(Actor.class), "main");
        final ActorRef actorA = system.actorOf(Props.create(Actor.class), "actorA");

        final ActorRef loadBalancer = system.actorOf(Props.create(LoadBalancer.class), "loadBalancer");

        main.tell(loadBalancer, ActorRef.noSender());

        loadBalancer.tell(2, main);
        loadBalancer.tell("t1", actorA);
        loadBalancer.tell("t2", actorA);
        loadBalancer.tell("t3", actorA);

        loadBalancer.tell("kill-children", ActorRef.noSender());


        try{
            Thread.sleep(5000);
        }catch (Exception e){

        }finally {
            system.terminate();
        }
    }
}
