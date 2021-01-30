# Implementation
## Creating the Actor system

Actors A, B, and C are created alongside the load balancer. 

Actors B and C send join messages to inform the load balancer that they are ready to receive and 
process requests. Actor A sends its messages (_m1, m2, m3, m4_) to the load balancer.

The load balancer, in a round-robin fashion, distributes the requests received from actor A amongst actors B and C.
It keeps an internal `round` state; this tells whose round it is to serve.
It accepts the references of the actors to serve (workers: actors B and C) in a vector called `actors`.  

    round = round % actors.size()
    send message to actors.get(round);
    round += 1;

If an actor disconnects from the system by messaging "unjoin" to the load balancer, the size of the load balancer's actors decrease. 