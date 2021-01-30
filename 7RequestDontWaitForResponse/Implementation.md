# Implementation
## Creating the Actor system

After creating the actor system, the system creates 2 actors: A and B. They communicate by sending messages; actorA sends requests and they
are responded by actorB.

When actorA sends a request, it doesn't wait for the response. This is a non-blocking communication since actorA continues executing 
the rest of its tasks.