import actors.Actor;
import actors.Publisher;
import actors.Topic;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class Main {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("system");

        final ActorRef actorA = system.actorOf(Actor.createActor(), "actorA");
        final ActorRef actorB = system.actorOf(Actor.createActor(), "actorB");
        final ActorRef actorC = system.actorOf(Actor.createActor(), "actorC");

        final ActorRef publisher1 = system.actorOf(Publisher.createPublisher(), "publisher1");
        final ActorRef publisher2 = system.actorOf(Publisher.createPublisher(), "publisher2");

        final ActorRef topic1 = system.actorOf(Topic.createTopic(), "topic1");
        final ActorRef topic2 = system.actorOf(Topic.createTopic(), "topic2");


        topic1.tell("subscribe", actorA);
        topic1.tell("subscribe", actorB);
        topic2.tell("subscribe", actorB);
        topic2.tell("subscribe", actorC);

        topic1.tell("hello", publisher1);
        topic2.tell("world", publisher2);

        topic1.tell("unsubscribe", actorA);
        topic1.tell("hello2", publisher1);


        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            system.terminate();
        }
    }
}
