package com.tdd.ds;

//https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {

    public boolean hasCycle(final ListNode head) {

        if(head == null) {
            return false;
        }

        if(head.getNext() == head) {
            return true;
        } else if (head.getNext() == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.getNext().getNext();

        while(slow != null && slow.getNext() != null && fast != null && fast.getNext() != null && fast.getNext().getNext() != null) {
            if(slow == fast) {
                return true;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return false;
    }
}
