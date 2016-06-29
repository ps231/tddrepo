package com.tdd.ds;

import org.junit.Assert;
import org.junit.Test;

public class ReverseSingleLinkedListTest {

    private ReverseSingleLinkedList instance = new ReverseSingleLinkedList();

    @Test
    public void shouldReturnNullIfTheInputNodeIsNull() {
        Assert.assertNull(instance.reverseList(null));
    }

    @Test
    public void shouldReturnTheSameNodeForSingleNodeLinkedList() {
        ListNode head = createSingleLinkedList(1);

        Assert.assertEquals(head, instance.reverseList(head));
    }

    @Test
    public void shouldReturnReversedListForMultipleNodeLinkedList() {
        final int size = 10;
        ListNode head = createSingleLinkedList(size);
        int[] headArray = getArray(head, size);

        ListNode reversedHead = instance.reverseList(head);
        int[] reversedArray = getArray(reversedHead, size);

        Assert.assertEquals(headArray.length, reversedArray.length);
        for(int i = 0, j=headArray.length - 1; i<headArray.length; i++, j--) {
            Assert.assertEquals(headArray[i], reversedArray[j]);
        }
    }

    private int[] getArray(ListNode head, int size) {
        int[] listToArray = new int[size];
        for(int i =0; i<size; i++) {
            listToArray[i] = head.getVal();
            head = head.getNext();
        }
        return  listToArray;
    }

    private ListNode createSingleLinkedList(int size) {
        ListNode head = null;
        ListNode currentNode = null;

        for (int i = 0; i< size; i++) {
            if(currentNode == null ) {
                currentNode = createNewNode(i);
                head = currentNode;
            } else {
                currentNode.setNext(createNewNode(i));
                currentNode = currentNode.getNext();
            }
        }
        return head;
    }

    private ListNode createNewNode(int val) {
        ListNode node = new ListNode();
        node.setVal(val);
        node.setNext(null);
        return node;
    }
}