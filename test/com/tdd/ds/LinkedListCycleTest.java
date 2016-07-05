package com.tdd.ds;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListCycleTest {

    private LinkedListCycle instance = new LinkedListCycle();

    @Test
    public void shouldReturnFalseWhenNullIsPassed() {
        ListNode node = null;
        Assert.assertFalse(instance.hasCycle(node));
    }

    @Test
    public void shouldReturnFalseWhenSingleNodeListIsPassed() {
        ListNode node = createSingleLinkedList(1);
        Assert.assertFalse(instance.hasCycle(node));
    }

    @Test
    public void shouldReturnTrueWhenSingleNodeCircularListIsPassed() {
        ListNode node = createSingleLinkedList(1);
        node.setNext(node);
        Assert.assertTrue(instance.hasCycle(node));
    }

    @Test
    public void shouldReturnFalseWhenTwoNodeSingleLinkedListIsPassed() {
        ListNode node = createSingleLinkedList(2);
        Assert.assertFalse(instance.hasCycle(node));
    }

    @Test
    public void shouldReturnTrueWhenTwoNodeCircularListIsPassed() {
        ListNode node = createSingleLinkedList(2);
        node.getNext().setNext(node);
        Assert.assertTrue(instance.hasCycle(node));
    }

    @Test
    public void shouldReturnTrueWhenMultipleNodeCircularListIsPassed() {
        ListNode node = createSingleLinkedList(5);
        node.getNext().getNext().setNext(node);
        Assert.assertTrue(instance.hasCycle(node));
    }

    @Test
    public void shouldReturnTrueWhenMultipleNodeCircularListIsPassed1() {
        ListNode node = createSingleLinkedList(6);
        ListNode cycleNode = node.getNext();
        cycleNode.getNext().getNext().setNext(cycleNode);
        Assert.assertTrue(instance.hasCycle(node));
    }

    @Test
    public void shouldReturnFalseWhenMultipleNodeSingleLinkedListIsPassed() {
        ListNode node = createSingleLinkedList(4);
        Assert.assertFalse(instance.hasCycle(node));
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
}
