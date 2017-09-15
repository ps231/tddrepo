package com.tdd.graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    int value;
    List<GraphNode> adjacent;

    public GraphNode(int value) {
        this.value = value;
        this.adjacent = new ArrayList<>();
    }

    public void addEdge(GraphNode node) {
        adjacent.add(node);
        node.adjacent.add(this);
    }
}
