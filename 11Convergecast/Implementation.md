# Implementation
## Creating the Actor system

After setting up the actor system, actors A, B, C, and D are created. A merger actor is created.

Actor D receives messages from actors A, B, C. Actors A, B, C schedule their messages after **1 s**. The actors A, B, C send "join" messages to the merger to join.
The scheduler after the 
elapsed time sends a "go" message to the actor to send its message to the merger actor.

An actor sends an "unjoin" message to the merger to disconnect.
