package com.tdd.search;

import java.util.ArrayList;
import java.util.List;

// given a list of intervals, add an interval and return the union list of all existing intervals
// eg - (-4,-1), (0,2), (3,6), (7,9) is the list and (1,8) needs to be added, the result will be
// (-4,-1), (0,9)
public class UnionOfIntervals {
    public static void main(final String... args) {
        System.out.println("(2,3) - " + intervalUnion(getExistingIntervals(), new Interval(2, 3)));
        System.out.println("(1,8) - " + intervalUnion(getExistingIntervals(), new Interval(1, 8)));
        System.out.println("(9,10) - " + intervalUnion(getExistingIntervals(), new Interval(9, 10)));
        System.out.println("(10,11) - " + intervalUnion(getExistingIntervals(), new Interval(10, 11)));
        System.out.println("(13,15) - " + intervalUnion(getExistingIntervals(), new Interval(13, 15)));
//        not working for this case.
//        System.out.println("(10,13) - " + intervalUnion(getExistingIntervals(), new Interval(10, 13)));
    }

    private static List<Interval> getExistingIntervals() {
        final List<Interval> existing = new ArrayList<>();
        existing.add(new Interval(-4, -1));
        existing.add(new Interval(0, 2));
        existing.add(new Interval(3, 6));
        existing.add(new Interval(7, 9));
        existing.add(new Interval(11, 12));
        return existing;
    }

    public static List<Interval> intervalUnion(final List<Interval> existingIntervals, final Interval newInterval) {
        final List<Interval> intervalUnion = new ArrayList<>();
        boolean intersectionAdded = false;
        for(int i = 0; i < existingIntervals.size(); i++) {
            final Interval existing = existingIntervals.get(i);
            if (intersects(existing, newInterval)) {
                if(intersectionAdded) {
                    Interval current = intervalUnion.get(intervalUnion.size() - 1);
                    current.startTime = Math.min(current.startTime, existing.startTime);
                    current.endTime = Math.max(current.endTime, existing.endTime);
                } else {
                    intervalUnion.add(new Interval(Math.min(existing.startTime, newInterval.startTime), Math.max(existing.endTime, newInterval.endTime)));
                    intersectionAdded = true;
                }
            } else {
                if (!intervalUnion.isEmpty() && intersects(intervalUnion.get(intervalUnion.size() - 1), existing)) {
                    continue;
                } else {
                    intervalUnion.add(existing);
                }
            }
        }
        if (!intersectionAdded) {
            intervalUnion.add(newInterval);
        }
        return intervalUnion;
    }

    private static boolean intersects(Interval existing, Interval newInterval) {
        return newInterval.startTime >= existing.startTime && newInterval.startTime <= existing.endTime
                || newInterval.endTime >= existing.startTime && newInterval.endTime <= existing.endTime
                ? true
                : false;
    }
}

class Interval {

    int startTime;
    int endTime;

    Interval(final int startTime, final int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
