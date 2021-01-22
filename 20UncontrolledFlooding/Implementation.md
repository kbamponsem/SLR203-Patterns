# Implementation
## Creating the Actor System

After creating the actor system, nodes 1 to n are created. At creation, unique names are passed to the nodes: nodeA,
nodeB, nodeC, nodeD or node1, node2, node3, and so on.

After the creation of nodes, the neighbors of each node are sent by `ActorRef.noSender` to each node.

## How communication happens in the network

Nodes, upon receiving messages from its neighbors, forwards them to its receiving neighbors. Since this graph
is directed, inter-node communication is unidirectional. With uncontrolled flooding, the nodes keeps forwarding 
received messages. The cycle never ends.