package com.tdd.ds;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(final String... args) {
        final ListNode list1 = new ListNode(2);
        final ListNode list2 = new ListNode(3);
        final ListNode list3 = new ListNode(5);

        list1.next = new ListNode(4);
        list1.next.next = new ListNode(6);
//        list1.next.next.next = new ListNode(8);

        list2.next = new ListNode(6);
//        list2.next.next = new ListNode(9);
//        list2.next.next.next = new ListNode(12);

        list3.next = new ListNode(10);
        list3.next.next = new ListNode(15);

        final ListNode[] lists = {list1, list2, list3};

        ListNode mergedHead = mergeKLists(lists);
        printList(mergedHead);
//        mergedHead = mergeKLists(new ListNode[] {});
//        printList(mergedHead);
        mergedHead = mergeKLists(null);
        printList(mergedHead);
        mergedHead = mergeKLists(new ListNode[] {new ListNode(1), new ListNode(0)});
        printList(mergedHead);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode mergeKLists(final ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;

        ListNode head = new ListNode(-1);
        ListNode ptr = head;
        final PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, (ListNode n1, ListNode n2) -> { return Integer.compare(n1.val, n2.val); });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                queue.add(lists[i]);
        }

        while (!queue.isEmpty()) {
            ptr.next = queue.poll();
            ptr = ptr.next;
            if (ptr.next != null)
                queue.add(ptr.next);
        }

        return head.next;
    }
}
