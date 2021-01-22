# Implementation
## Creating the system
After creating the actor system, nodes 1 to n are created. At creation, unique names are passed to the nodes: nodeA,
nodeB, nodeC, nodeD or node1, node2, node3, and so on.

After the creation of nodes, the neighbors of each node are sent by `ActorRef.noSender` to each node.



    node1.tell(new ActorRef[]{node2, node3}, ActorRef.noSender());
    node2.tell(new ActorRef[]{node4}, ActorRef.noSender());
    node4.tell(new ActorRef[]{node1, node4}, ActorRef.noSender());
    node3.tell(new ActorRef[]{node3, node1}, ActorRef.noSender());


## How nodes communicate

Nodes, upon receiving messages from its neighbors, forwards them to its receiving neighbors. Since this graph
is directed, inter-node communication is unidirectional. Also, the neighbors (nodes receiving from a node) are displayed.
