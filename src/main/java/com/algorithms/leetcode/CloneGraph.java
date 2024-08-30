package com.algorithms.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
    Given a reference of a node in a connected undirected graph.

    Return a deep copy (clone) of the graph.

    Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

    class Node {
        public int val;
        public List<Node> neighbors;
        }
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {

        // Create a hashmap to store the current node and it's cloned version
        Map<Node, Node> cloneMap = new HashMap<>();

        // Use a queue to do breadth first search
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        cloneMap.put(node, new Node(node.val));

        while(!queue.isEmpty()){
            Node curr = queue.poll();
            Node currClone = cloneMap.get(curr);

            for(Node neighbor: curr.neighbors){


                if(!cloneMap.containsKey(neighbor)) {
                    cloneMap.put(neighbor, new Node(neighbor.val));

                    // We don't want to add the elements more than once to the queue, so we do that
                    // inside the if block, so that each element is only processed once in the while loop
                    queue.add(neighbor);
                }

                currClone.neighbors.add(cloneMap.get(neighbor));

            }
        }
        return cloneMap.get(node);
    }
}
