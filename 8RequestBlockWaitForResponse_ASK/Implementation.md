# Implementation
## Creating the Actor system

After creating the actor system, the system creates two actors A and B. They are supposed to be communicating by 
sending messages: a sends a request and be responds.

After actorA sends a request, it awaits a `Future<Object>` from actorB. If actorB responds, actorA continues with its 
execution. This communication is blocking since actorA waits on a `Future<Object>`.