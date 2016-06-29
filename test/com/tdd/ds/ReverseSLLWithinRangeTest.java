package com.tdd.ds;

import org.junit.Assert;
import org.junit.Test;


public class ReverseSLLWithinRangeTest {

    private ReverseSLLWithinRange instance = new ReverseSLLWithinRange();

    @Test
    public void shouldDoNothingIfRangeIsForSingleElement() {
        int size = 4;
        ListNode head  = createSingleLinkedList(size);
        int[] headArray = getArray(head, size);

        ListNode reversedHead = instance.reverseWithinRange(head, 1, 1);
        int[] reversedArray = getArray(reversedHead, size);

        Assert.assertArrayEquals(headArray, reversedArray);
    }

//    @Test
//    public void

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
