# Implementation
# Creating the Actor system

In this actor system, a lot of actors were created. And so, there was the need to create
classes for the various types and then through naming, refer to the different actors.
\
Publishers, topics and the actors were created.
\
Actors A and B subscribed to topic1 and B and C, topic2.
\
Publisher1 sends _hello_ to topic1 and Publisher2 sends _world_ to topic2.
\
ActorA unsubscribes from topic1.
\
After, Publisher1 sends _hello2_ to topic1.

Actors subscribed to any of the topics receives the message published.

    [ actorA, actorB ] <--- hello (topic1)

    [ actorB, actorC ] <--- world (topic2)
    
    [ actorB ]         <--- hello2 (topic1)