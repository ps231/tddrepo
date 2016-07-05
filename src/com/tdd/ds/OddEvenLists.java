package com.tdd.ds;

//https://leetcode.com/problems/odd-even-linked-list/
public class OddEvenLists {
    public ListNode arrangeOddEven(final ListNode head) {
        if (head == null || head.getNext() == null || head.getNext().getNext() == null) {
            return head;
        } else {
            return rearrangeOddAndEvenNodes(head, head.getNext());
        }
    }

    private ListNode rearrangeOddAndEvenNodes(ListNode lastOdd, ListNode even) {
        ListNode firstEven = even;
        ListNode firstOdd = lastOdd;
        while(even != null && even.getNext() != null) {
            lastOdd.setNext(even.getNext());
            lastOdd = lastOdd.getNext();
            even.setNext(lastOdd.getNext());
            even = even.getNext();
        }
        lastOdd.setNext(firstEven);
        return firstOdd;
    }
}

