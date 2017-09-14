package com.tdd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Warehouse {

    public static void main(final String[] args) {
        Warehouse w = new Warehouse();
        List<Location> nearestLocations = w.findNearestCrates(3, 2, w.getLocations());
        nearestLocations.stream().forEach(System.out::println);
    }

    private List<Location> findNearestCrates(final int totalCrates, final int truckCapacity, final List<Location> crateLocations) {

        Queue<Location> minHeap = new PriorityQueue<>(Comparator.comparingDouble((o1) -> o1.distance));
        List<Location> nearestCrates = new ArrayList<>();

        for (final Location crateLoc : crateLocations) {
            crateLoc.distance = getDistance(crateLoc);
            minHeap.add(crateLoc);
        }

        for (int i = 0; i < truckCapacity && !minHeap.isEmpty(); i++) {
            nearestCrates.add(minHeap.poll());
        }

        return nearestCrates;
    }

    private double getDistance(Location loc) {
        return Math.sqrt(Math.pow(loc.x, 2) + Math.pow(loc.y, 2));
    }

    public List<Location> getLocations() {
        List<Location> locations = new ArrayList<>();
        locations.add(new Location(-1, -1, 0));
        locations.add(new Location(3, -2, 0));
        locations.add(new Location(1, 2, 0));
        return locations;
    }
}

class Location {
    int x;
    int y;
    double distance;

    public Location(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", distance=" + distance +
                '}';
    }
}
