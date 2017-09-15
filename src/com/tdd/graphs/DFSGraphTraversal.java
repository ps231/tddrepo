package com.tdd.graphs;

import java.util.HashSet;
import java.util.Set;

public class DFSGraphTraversal {
    public static void main(final String[] args) {
        DFSGraphTraversal t = new DFSGraphTraversal();
        t.traverse(GraphNodeHelper.getGraph());
    }

    private void traverse(GraphNode node) {
        traverseHelper(node, new HashSet<>());
    }

    private void traverseHelper(GraphNode node, Set<Integer> visited) {
        if (visited.contains(node.value))
            return;

        System.out.println(node.value);
        visited.add(node.value);

        for (GraphNode child : node.adjacent) {
            traverseHelper(child, visited);
        }
    }
}
