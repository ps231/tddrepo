package com.tdd.ds;

//https://leetcode.com/problems/odd-even-linked-list/
public class OddEvenLists {
    public ListNode arrangeOddEven(final ListNode head) {
        if (head == null || head.getNext() == null || head.getNext().getNext() == null) {
            return head;
        } else {
            ListNode odd = head;
            ListNode lastNode = head;
            final ListNode even = head.getNext();
            int i = 1;
            while (odd.getNext() != null) {
                lastNode = odd;
                odd = reArrangeLinks(odd);
                i++;
            }

            if (i % 2 == 0)
                lastNode.setNext(even);
            else
                odd.setNext(even);
            return head;
        }
    }

    private ListNode reArrangeLinks(final ListNode current) {
        final ListNode next = current.getNext();
            current.setNext(next.getNext());
            return next;
    }
}
