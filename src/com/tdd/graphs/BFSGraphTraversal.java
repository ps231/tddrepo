package com.tdd.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFSGraphTraversal {
    public static void main(final String[] args) {
        BFSGraphTraversal t = new BFSGraphTraversal();
        t.traverse(GraphNodeHelper.getGraph());
    }

    private void traverse(GraphNode node) {
        traverseHelper(node, new HashSet<>());
    }

    private void traverseHelper(GraphNode node, Set<Integer> visited) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            GraphNode n = queue.poll();

            if (visited.contains(n.value))
                continue;

            System.out.println(n.value);
            visited.add(n.value);

            queue.addAll(n.adjacent);
        }
    }
}
