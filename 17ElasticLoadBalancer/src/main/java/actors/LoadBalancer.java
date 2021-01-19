package actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import akka.pattern.Patterns;
import akka.util.Timeout;
import messages.Request;
import messages.Response;
import scala.concurrent.Await;
import scala.concurrent.Future;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class LoadBalancer extends UntypedAbstractActor {
    int max, round = 0;
    HashMap<String, ActorRef> refs = new HashMap<>();
    Vector<String> messageQueue = new Vector<>();

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof Integer) {
            max = (int) message;
            System.out.println("Max load is " + max);
        }
        if (message instanceof String) {
            if (getSender().path().name().equals("actorA")) {
                messageQueue.add((String) message);
                messageQueue.forEach(System.out::println);
                if (refs.size() < max) {
                    ActorRef actor = getContext().getSystem().actorOf(Props.create(Actor.class), "actor" + refs.size());
                    actor.tell(getSelf(), getSelf());
                    refs.put("actor" + refs.size(), actor);
                }
                Timeout timeout = Timeout.create(Duration.ofSeconds(5));

                Future<Object> future = Patterns.ask(refs.get("actor" + (round % max)), new Request((String) message), timeout);
                round++;

                Response response = (Response) Await.result(future, timeout.duration());
                if (response.getCode().equals("finished")) {
                    messageQueue.remove(response.getMessage());
                }

            }

            if(message.equals("kill-children")){
                refs.forEach((x,y)->{
                    getContext().stop(y);
                });
            }
        }
        if(message instanceof Request){
            System.out.println(((Request) message).getMessage());
        }
    }

}