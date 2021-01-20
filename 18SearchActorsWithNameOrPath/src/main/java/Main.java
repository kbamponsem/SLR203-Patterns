import actors.Actor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("system");
        ActorRef actorA = system.actorOf(Props.create(Actor.class), "actorA");
        ActorRef searcher = system.actorOf(Props.create(Actor.class), "searcher");
        ActorRef displayer = system.actorOf(Props.create(Actor.class), "displayer");

        actorA.tell("CREATE", ActorRef.noSender());
        actorA.tell("CREATE", ActorRef.noSender());
        actorA.tell("CREATE", ActorRef.noSender());
        actorA.tell("CREATE", ActorRef.noSender());

        searcher.tell("actor1", ActorRef.noSender());
        searcher.tell("actor2", ActorRef.noSender());
        searcher.tell("actor3", ActorRef.noSender());
        searcher.tell("actor4", ActorRef.noSender());

        displayer.tell("display", ActorRef.noSender());

        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            system.terminate();
        }
    }
}
