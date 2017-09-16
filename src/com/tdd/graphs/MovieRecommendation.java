package com.tdd.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class MovieRecommendation {
    public static void main(final String[] args) {
        new MovieRecommendation()
                .getRecommendations(getMovieGraph(), 2)
                .stream()
                .map((m) -> "Movie name: " + m.value + ", Movie rating: " + m.rating)
                .forEach(System.out::println);
    }

    private List<MovieNode> getRecommendations(MovieNode node, int k) {
        Set<Integer> visited = new HashSet<>();
        Queue<MovieNode> recoMaxHeap = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2.rating, o1.rating)));
        Queue<MovieNode> movieQ = new LinkedList<>();
        List<MovieNode> movies = new ArrayList<>();

        movieQ.addAll(node.adjacent);
        visited.add(node.value);

        while (!movieQ.isEmpty()) {
            MovieNode m = movieQ.poll();

            if (visited.contains(m.value))
                continue;

            visited.add(m.value);
            movieQ.addAll(m.adjacent);
            recoMaxHeap.add(m);
        }

        for (int i = 0; i < k; i++) {
            movies.add(recoMaxHeap.poll());
        }

        return movies;
    }

    public static MovieNode getMovieGraph() {
        MovieNode m1 = new MovieNode(1, 2);
        MovieNode m2 = new MovieNode(2, 6);
        MovieNode m3 = new MovieNode(3, 4);
        MovieNode m4 = new MovieNode(4, 8);

        m1.addEdge(m2);
        m1.addEdge(m3);

        m2.addEdge(m4);
        m3.addEdge(m4);

        return m1;
    }
}

class MovieNode {
    public int rating;
    int value;
    List<MovieNode> adjacent;

    public MovieNode(int value, int rating) {
        this.value = value;
        this.rating = rating;
        this.adjacent = new ArrayList<>();
    }

    public void addEdge(MovieNode node) {
        adjacent.add(node);
        node.adjacent.add(this);
    }
}
