package com.tdd.ds;

public class MergeAllOddAndReversedEvenLocations {

    public static void main(final String[] args) {
        final ListNode input = createLinkedList();
        printList("input list", input);
        ListNode output = mergeAllOddAndReversedEvenLocations(input);
        printList("output list", output);
    }

    private static void printList(String message, ListNode node) {
        System.out.println(message);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static ListNode mergeAllOddAndReversedEvenLocations(ListNode node) {

        if (node.next == null)
            return node;

        ListNode even = node;
        ListNode odd = even.next;
        ListNode newHead = odd;

        while(odd.next != null) {
            ListNode nextEven = odd.next;
            ListNode nextOdd = nextEven.next;

            if (even == node) {
                even.next = null;
            }

            if (nextEven != null) {
                nextEven.next = even;
                even = nextEven;
            }

            odd.next = nextOdd;

            if (nextOdd != null)
                odd = nextOdd;
        }

        odd.next = even;

        if (even == node)
            even.next = null;

        return newHead;
    }

    private static ListNode createLinkedList() {
        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(4);
        return root;
    }
}
