package com.tdd.graphs;

public class GraphNodeHelper {
    public static GraphNode getGraph() {
        GraphNode one = new GraphNode(1);
        GraphNode two = new GraphNode(2);
        GraphNode three = new GraphNode(3);
        GraphNode four = new GraphNode(4);
        GraphNode five = new GraphNode(5);

        one.addEdge(two);
        one.addEdge(three);

        two.addEdge(four);
        two.addEdge(three);

        three.addEdge(four);
        three.addEdge(five);

        return one;
    }
}