# Implementation
## Creating the Actor System

Three categories of actors are created: broadcaster, workers, and message sender.
The two workers send join messages to the broadcaster to inform them that they are ready to receive 
messages and process them, if necessary.

The message sender, actorA, schedules its message after **1 s**.
After **1 s**, actorA sends a message m to the broadcaster.
Then, the broadcaster forwards the message to the workers [ actorB, actorC ].