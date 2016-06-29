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

   @Test
    public void shouldReverseOnlyPartOfTheList() {
        int size = 5;
        ListNode head  = createSingleLinkedList(size);
        printList(head);
        ListNode reversedHead = instance.reverseWithinRange(head, 2, 3);
        printList(reversedHead);

        head  = createSingleLinkedList(size);
        printList(head);
        reversedHead = instance.reverseWithinRange(head, 2, 4);
        printList(reversedHead);

        head  = createSingleLinkedList(size);
        printList(head);
        reversedHead = instance.reverseWithinRange(head, 1, 4);
        printList(reversedHead);

        head  = createSingleLinkedList(size);
        printList(head);
        reversedHead = instance.reverseWithinRange(head, 4, 5);
        printList(reversedHead);

        head  = createSingleLinkedList(size);
        printList(head);
        reversedHead = instance.reverseWithinRange(head, 1, 5);
        printList(reversedHead);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfEndIsOutOfRange() {
        instance.reverseWithinRange(createSingleLinkedList(5), 1, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfStartIsOutOfRange() {
        instance.reverseWithinRange(null, 0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfEndIsLessThanStart() {
        instance.reverseWithinRange(null, 3, 2);
    }


    private void printList(ListNode head) {
        while(head.getNext() != null) {
            System.out.print(head.getVal() + " ");
            head = head.getNext();
        }
        System.out.println(head.getVal());
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
                currentNode = createNewNode(i*2 + 1);
                head = currentNode;
            } else {
                currentNode.setNext(createNewNode(i*2 + 1));
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
