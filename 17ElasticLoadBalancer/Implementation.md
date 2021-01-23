# Implementation

## Creating the Actor system
First, the **main**, **actorA**, and **loadbalancer** actors are created.\
Next, the system sends the reference of the load balancer to the main actor.\
The **main** actor notifies the load balancer to create and share any incoming requests amongst 2 workers (**actorA** and **actorB**.)

Two message types are created: _Request_ and _Response_.\
If the load balancer receives a request from actorA, it forwards the message to the workers in a round-robin fashion.

A **_stop_** signal kills any worker receiving the message from the load balancer.

