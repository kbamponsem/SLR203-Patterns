# Implementation
## Creating the Actor system

Two groups of actors were created: receivers and multicast actors.
Receivers 1, 2, and 3. 

The receiver actors were grouped into 2: _group1_, _group2_.
    
    group1 : { receiver1, receiver2 }
    group2 : { receiver2, receiver3 }

The system sends the two groups to the multicast actor - this actor upon receiving messages forwards them to 
the different groups respectively.

The system forwards messages _hello_ and world to groups 1 and 2 respectively.
The multicast actor forwards the messages to their respective groups.