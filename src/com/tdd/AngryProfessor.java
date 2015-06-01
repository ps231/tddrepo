package com.tdd;

public class AngryProfessor {
    private final int totalStudents;
    private final int minExpectedStudents;
    private final int[] studentArrivalTimes;

    public AngryProfessor(final int totStudents, final int minStudents, final int[] arrivalTime) {
        validateArguments(totStudents, minStudents, arrivalTime);
        this.totalStudents = totStudents;
        this.minExpectedStudents = minStudents;
        this.studentArrivalTimes = arrivalTime;
    }

    private void validateArguments(final int totStudents, final int minStudents, final int[] arrivalTime) {
        validateMinExpectedStudents(totStudents, minStudents);
        validateTotalStudents(totStudents);
        validateStudentArrivalTimes(totStudents, arrivalTime);
    }

    private void validateStudentArrivalTimes(final int totalStudents2, final int[] arrivalTime) {
        if (arrivalTime.length != totalStudents2) {
            throwIllegalArgEx("arrival times for all students is not specified");
        }
    }

    private void validateTotalStudents(final int totalStudents2) {
        if (totalStudents2 < 1 || totalStudents2 > 1000) {
            throwIllegalArgEx("total no of students should be within 1 to 1000");
        }
    }

    private void validateMinExpectedStudents(final int totalStudents2, final int minExpectedStudents2) {
        if (minExpectedStudents2 < 1 || minExpectedStudents2 > totalStudents2) {
            throwIllegalArgEx("min expected no of students should be within 1 and " + totalStudents2);
        }
    }

    private void throwIllegalArgEx(final String exMessage) {
        throw new IllegalArgumentException(exMessage);
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public int getMinExpectedStudents() {
        return minExpectedStudents;
    }

    public String isClassCancelled() {
        int countOfStudentsBeforeTime = 0;
        for (final int arrivalTime : studentArrivalTimes) {
            if (getValidatedStudentArrivalTime(arrivalTime) <= 0) {
                countOfStudentsBeforeTime++;
            }
            if (countOfStudentsBeforeTime >= minExpectedStudents) {
                return "NO";
            }
        }
        return "YES";
    }

    private int getValidatedStudentArrivalTime(final int arrivalTime) {
        if (!arrivalTimeWithinValidRange(arrivalTime)) {
            throwIllegalArgEx("arrival time must be within valid range");
        }
        return arrivalTime;
    }

    private boolean arrivalTimeWithinValidRange(final int arrivalTime) {
        return arrivalTime >= -100 && arrivalTime <= 100;
    }

}
