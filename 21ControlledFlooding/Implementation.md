# Implementation
# Creating the Actor System

After creating the actor system, nodes 1 to n are created. At creation, unique names are passed to the nodes: nodeA,
nodeB, nodeC, nodeD or node1, node2, node3, and so on.

After the creation of nodes, the neighbors of each node are sent by `ActorRef.noSender` to each node.

        nodeA.tell(new ActorRef[]{nodeB, nodeC}, ActorRef.noSender());

        nodeB.tell(new ActorRef[]{nodeD}, ActorRef.noSender());

        nodeC.tell(new ActorRef[]{nodeD}, ActorRef.noSender());

        nodeD.tell(new ActorRef[]{nodeE}, ActorRef.noSender());

## How communication happens in the network
The sharing of messages starts after **nodeA** receives a _START_ message from the Actor system. After receiving the _START_
message, it sends "hello" to its neighbors and alongside tags the message with a unique identifier - 0 in this case.

In addition, each node has a vector for sequence numbers. This is used to distinguish if a message has been received or not.

    
    if (sequenceNumbers.contains(message.sequenceNumber))
        drop message;
    else
        send message -> allNeighbors;
    