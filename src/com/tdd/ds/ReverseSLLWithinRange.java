package com.tdd.ds;

import com.sun.javaws.exceptions.InvalidArgumentException;

//https://leetcode.com/problems/reverse-linked-list-ii/
public class ReverseSLLWithinRange {
    public ListNode reverseWithinRange(ListNode head, int start, int end) {
        if (start < 1) {
            throw new IllegalArgumentException("invalid start range");
        }

        if (end < start) {
            throw new IllegalArgumentException("invalid start and end range");
        }

        if (start == end) {
            return head;
        }

        int startCounter = 1;
        ListNode current = head;
        ListNode previous = current;
        while(startCounter != start) {
            previous = current;
            current = current.getNext();
            startCounter++;
        }

        ListNode next = current.getNext();
        ListNode nextPlusOne = null;
        while(startCounter < end) {
            if(next == null) {
                throw new IllegalArgumentException("invalid end range");
            }

            nextPlusOne = next.getNext();
            next.setNext(current);
            current = next;
            next = nextPlusOne;
            startCounter++;
        }

        if(start == 1) {
            previous.setNext(next);
            return current;
        } else {
            previous.getNext().setNext(next);
            previous.setNext(current);
        }
        return head;
    }
}
