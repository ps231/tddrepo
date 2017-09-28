package com.tdd.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(final String... args) {
        MergeIntervals.merge(getIntervalList()).stream().forEach(System.out::println);
    }

    private static List<Interval> merge(List<Interval> intervals) {
        final List<Interval> merged = new ArrayList<>();
        intervals.sort(Comparator.comparingInt((i1) -> i1.startTime));

        for (final Interval i : intervals) {
            if (merged.isEmpty())
                merged.add(i);

            if (currentIntervalConflictsWithPrevious(i, merged))
                combineCurrentIntervalWithPrevious(i, merged);
            else
                merged.add(i);
        }
        return merged;
    }

    private static void combineCurrentIntervalWithPrevious(Interval current, List<Interval> existing) {
        existing.get(existing.size() - 1).endTime = Math.max(existing.get(existing.size() - 1).endTime, current.endTime);
    }

    private static boolean currentIntervalConflictsWithPrevious(Interval current, List<Interval> existing) {
        return current.startTime <= existing.get(existing.size() - 1).endTime;
    }

    public static List<Interval> getIntervalList() {
        final List<Interval> existing = new ArrayList<>();
        existing.add(new Interval(1, 3));
        existing.add(new Interval(15, 18));
        existing.add(new Interval(4, 8));
        existing.add(new Interval(8, 10));
        existing.add(new Interval(2, 6));
        existing.add(new Interval(3, 5));
        return existing;
    }
}
