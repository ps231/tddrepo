package com.tdd;

public class AngryProfessor {
    private final int totalStudents;
    private final int minExpectedStudents;
    private final String[] studentArrivalTimes;

    public AngryProfessor(final int totalStudents, final int minExpectedStudents, final String[] arrivalTime) {
        validateArguments(totalStudents, minExpectedStudents, arrivalTime);
        this.totalStudents = totalStudents;
        this.minExpectedStudents = minExpectedStudents;
        this.studentArrivalTimes = arrivalTime;
    }

    private void validateArguments(final int totalStudents2, final int minExpectedStudents2, final String[] arrivalTime) {
        validateMinExpectedStudents(totalStudents2, minExpectedStudents2);
        validateTotalStudents(totalStudents2);
        validateStudentArrivalTime(totalStudents2, arrivalTime);
    }

    private void validateStudentArrivalTime(final int totalStudents2, final String[] arrivalTime) {
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

}
