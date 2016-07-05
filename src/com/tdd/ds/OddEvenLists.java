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

    private ListNode rearrangeOddAndEvenNodes(ListNode odd, ListNode even) {
        ListNode firstEven = even;
        ListNode firstOdd = odd;
        while(even != null && even.getNext() != null) {
            odd.setNext(even.getNext());
            odd = odd.getNext();
            even.setNext(odd.getNext());
            even = even.getNext();
        }
        odd.setNext(firstEven);
        return firstOdd;
    }
}

