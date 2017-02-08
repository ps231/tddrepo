package com.tdd.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//write a program which takes as input student test scores and returns the student who has the maximum score averaged
//across his or her top 3 scores. if the student has fewer than three scores, ignore that student
public class AverageOfTopKScores {

    public static void main(final String... args) {
        final List<NameScore> studentScoreRecords = new ArrayList<>();
        studentScoreRecords.add(new NameScore("STU1", 50));
        studentScoreRecords.add(new NameScore("STU2", 99));
        studentScoreRecords.add(new NameScore("STU3", 70));
        studentScoreRecords.add(new NameScore("STU1", 50));
        studentScoreRecords.add(new NameScore("STU3", 80));
        studentScoreRecords.add(new NameScore("STU3", 60));
        studentScoreRecords.add(new NameScore("STU2", 99));
        studentScoreRecords.add(new NameScore("STU1", 80));
        studentScoreRecords.add(new NameScore("STU1", 40));
        studentScoreRecords.add(new NameScore("STU1", 90));
        System.out.println(findStudentWithMaxAvgTopKScores(studentScoreRecords, 3));
    }

    private static String findStudentWithMaxAvgTopKScores(final List<NameScore> studentScoreRecords, final int noOfScores) {
        NameScore maxScoredStudentRecord = new NameScore(null, -1);
        final Map<String, PriorityQueue<Integer>> studentScoresMap = new HashMap<>();

        for (final NameScore ns : studentScoreRecords) {
            final PriorityQueue<Integer> studentTopMarksHeap = studentScoresMap.get(ns.name);
            if (studentTopMarksHeap == null) {
                final PriorityQueue<Integer> topKScoresHeap = initializePriorityQueue(noOfScores);
                topKScoresHeap.add(ns.score);
                studentScoresMap.put(ns.name, topKScoresHeap);
            } else {
                if (studentTopMarksHeap.size() < noOfScores) {
                    studentTopMarksHeap.add(ns.score);
                } else if (studentTopMarksHeap.size() == noOfScores && studentTopMarksHeap.peek() < ns.score) {
                    studentTopMarksHeap.poll();
                    studentTopMarksHeap.add(ns.score);
                }
            }
        }

        for (final Map.Entry<String, PriorityQueue<Integer>> entry : studentScoresMap.entrySet()) {
            if (entry.getValue().size() == noOfScores) {
                final int avgScore = calculateAvgScore(entry.getValue(), noOfScores);
                maxScoredStudentRecord = (maxScoredStudentRecord == null || maxScoredStudentRecord.score  < avgScore)
                        ? new NameScore(entry.getKey(), avgScore)
                        : maxScoredStudentRecord;
            }
        }

        return maxScoredStudentRecord.name;
    }

    private static int calculateAvgScore(final PriorityQueue<Integer> scores, final int noOfScores) {
        int sum = 0;
        for (Integer score : scores) {
            sum += score;
        }
        return sum / noOfScores;
    }

    private static PriorityQueue<Integer> initializePriorityQueue(final int noOfScores) {
        return new PriorityQueue<Integer>(noOfScores, (Integer i1, Integer i2) -> { return i1.compareTo(i2);} );
    }


    private static class NameScore {
        String name;
        int score;

        NameScore(final String name, final int score) {
            this.name = name;
            this.score = score;
        }
    }
}
