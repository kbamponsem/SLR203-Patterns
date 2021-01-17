package util;

import akka.actor.ActorRef;

import java.util.Vector;

public class Message {
    String group;
    ActorRef[] members;

    public Message(String group, ActorRef[] members){
        this.group = group;
        this.members = members;
    }

    public String getGroup() {
        return group;
    }

    public ActorRef[] getMembers() {
        return members;
    }
}
