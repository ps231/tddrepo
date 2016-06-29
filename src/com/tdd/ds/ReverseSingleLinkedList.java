package com.tdd.ds;

//https://leetcode.com/problems/reverse-linked-list/
public class ReverseSingleLinkedList {

    public ListNode reverseList(final ListNode head) {

        if (head == null) {
            return null;
        }

        if (head.getNext() == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode next = current.getNext();

        while(next != null) {
            current.setNext(prev);
            prev = current;
            current = next;
            next = next.getNext();
        }
        current.setNext(prev);
        return current;
    }
}
