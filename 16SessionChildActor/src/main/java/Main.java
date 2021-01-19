import actors.Client;
import actors.SessionManager;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import messages.ActorAndString;

public class Main {
    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("system");
        final ActorRef client1 = system.actorOf(Props.create(Client.class), "client1");
        final ActorRef sessionManager = system.actorOf(Props.create(SessionManager.class), "sessionManager");

        sessionManager.tell( "createSession", client1);

        try{
            Thread.sleep(5000);
        }catch (Exception e){

        }finally {
            system.terminate();
        }
    }
}
