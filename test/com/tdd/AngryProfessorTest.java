package com.tdd;

import org.junit.Test;

public class AngryProfessorTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfEvenSingleStudentIsNotInClass() {
        new AngryProfessor(10, 0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenLeastExpectedStudentsIsGreaterThanTotalStudents() {
        new AngryProfessor(1, 2, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenTotalStudentsIsLessThan1() {
        new AngryProfessor(0, 1, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenTotalStudentsIsGreaterThan1000() {
        new AngryProfessor(1001, 1, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfArrivalTimesOfAllStudentsIsNotSpecified() {
        new AngryProfessor(2, 1, new String[] { "1" });
    }
}
