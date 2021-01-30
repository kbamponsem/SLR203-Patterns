# Implementation
## Creating the Actor system

The system creates two categories of actors: intermediate-transmitter and message-transmitters. Actors A and B are transmitters. 
The intermediate transmitter forwards the message to it's intended recipient.

    [ actorA -> {(message, actorB)} -> intermediateTransmitter ]

    [ intermediateTransmitter -> {(message)} -> actorB ]