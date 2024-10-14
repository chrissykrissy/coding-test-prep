package coding.LeetCode;

import java.util.*;

public class Q133CloneGraph {

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

    Map<Integer, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(visited.containsKey(node.val)) return visited.get(node.val);
        Node newNode = new Node(node.val, new ArrayList<>());
        visited.put(newNode.val, newNode);
        for (Node n : node.neighbors) {
            newNode.neighbors.add(cloneGraph(n));
        }
        return newNode;
    }
}
