package com.tdd.ds;

import org.junit.Assert;
import org.junit.Test;

public class OddEvenListsTest {

    private OddEvenLists instance = new OddEvenLists();

    @Test
    public void shouldDoNothingIfNullListPassed() {
        final ListNode node = null;
        Assert.assertEquals(node, instance.arrangeOddEven(node));
    }

    @Test
    public void shouldReturnSameListIfLengthIsOne() {
        final ListNode expected = createSingleLinkedList(1);
        final ListNode actual = instance.arrangeOddEven(expected);

        assertListsAreSame(expected, actual, 1);
    }

    @Test
    public void shouldReturnSameListIfLengthIsTwo() {
        final ListNode expected = createSingleLinkedList(2);
        final ListNode actual = instance.arrangeOddEven(expected);

        assertListsAreSame(expected, actual, 2);
    }

    @Test
    public void shouldArrangeOddEvenIfInputListGreaterThanTwo() {
        final ListNode expected = createSingleLinkedList(3);
        printList(expected);
        final ListNode actual = instance.arrangeOddEven(expected);
        printList(actual);
    }


    @Test
    public void shouldArrangeOddEvenCorrectly() {
        ListNode expected = createSingleLinkedList(7);
        printList(expected);
        ListNode actual = instance.arrangeOddEven(expected);
        printList(actual);

        expected = createSingleLinkedList(3);
        printList(expected);
        actual = instance.arrangeOddEven(expected);
        printList(actual);
    }


    private void assertListsAreSame(final ListNode e, final ListNode a, final int size) {
        ListNode expected = e;
        ListNode actual = a;
        for (int i = 0; i < size; i++) {
            Assert.assertEquals(expected.getVal(), actual.getVal());
            Assert.assertEquals(expected.getNext(), actual.getNext());

            expected = expected.getNext();
            actual = actual.getNext();
        }
    }

    private ListNode createSingleLinkedList(final int size) {
        ListNode head = null;
        ListNode currentNode = null;

        for (int i = 0; i < size; i++) {
            if (currentNode == null ) {
                currentNode = createNewNode(i + 1);
                head = currentNode;
            } else {
                currentNode.setNext(createNewNode(i + 1));
                currentNode = currentNode.getNext();
            }
        }
        return head;
    }

    private ListNode createNewNode(final int val) {
        final ListNode node = new ListNode();
        node.setVal(val);
        node.setNext(null);
        return node;
    }

    private void printList(final ListNode head) {
        ListNode temp = head;
        while (temp.getNext() != null) {
            System.out.print(temp.getVal() + " ");
            temp = temp.getNext();
        }
        System.out.println(temp.getVal());
    }

}


