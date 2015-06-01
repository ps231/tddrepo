package com.tdd;

import org.junit.Assert;
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
        new AngryProfessor(2, 1, new int[] { 1 });
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfArrivalTimeIsInvalid() {
        final AngryProfessor ap = new AngryProfessor(2, 2, new int[] { -1, 101 });
        ap.isClassCancelled();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfArrivalTimeIsInvalid1() {
        final AngryProfessor ap = new AngryProfessor(2, 2, new int[] { -101, 101 });
        ap.isClassCancelled();
    }

    @Test
    public void shouldReturnNoIfMoreThanExpectedNoOfStudentsHaveEnteredClassBeforeTime() {
        final AngryProfessor ap = new AngryProfessor(2, 1, new int[] { -1, 0 });
        Assert.assertEquals("Should have returned true, when no of students entering before time is >= 1", "NO", ap.isClassCancelled());
    }

    @Test
    public void shouldReturnNoIfExactlyExpectedNoOfStudentsHaveEnteredClassBeforeTime() {
        final AngryProfessor ap = new AngryProfessor(2, 1, new int[] { 3, 0 });
        Assert.assertEquals("Should have returned true, when no of students entering before time is >= 1", "NO", ap.isClassCancelled());
    }

    @Test
    public void shouldReturnYesIfLessThanExpectedNoOfStudentsHaveEnteredClassBeforeTime() {
        final AngryProfessor ap = new AngryProfessor(2, 1, new int[] { 3, 5 });
        Assert.assertEquals("Should have returned false, when no of students entering before time is < 1", "YES", ap.isClassCancelled());
    }

    @Test
    public void shouldReturnYes() {
        final AngryProfessor ap = new AngryProfessor(2, 2, new int[] { -100, 100 });
        Assert.assertEquals("Should have returned false, when no of students entering before time is < 1", "YES", ap.isClassCancelled());
    }

    @Test
    public void test1() {
        AngryProfessor ap = new AngryProfessor(4, 3, new int[] { -1, -3, 4, 2 });
        Assert.assertEquals("Should have returned true, when no of students entering before time is >= 1", "YES", ap.isClassCancelled());
        ap = new AngryProfessor(4, 2, new int[] { 0, -1, 2, 1 });
        Assert.assertEquals("Should have returned true, when no of students entering before time is >= 1", "NO", ap.isClassCancelled());
    }
}
