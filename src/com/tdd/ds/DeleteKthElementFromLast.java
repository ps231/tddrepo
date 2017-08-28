package com.tdd.ds;


public class DeleteKthElementFromLast {

    public static void main(final String[] args) {
        final DeleteKthElementFromLast k = new DeleteKthElementFromLast();
        final ListNode root = createLinkedList(6);
        k.deleteKthNodeFromLast(root, 3);
        printList(root);
    }

    private static void printList(ListNode root) {
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

    private void deleteKthNodeFromLast(final ListNode root, final int k) {
        ListNode slow = root;
        ListNode fast = root;

        for (int i = 0; i < k; i++) {
            if (fast != null)
                fast = fast.next;
        }

        if (fast == null)
            return;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
    }

    private static ListNode createLinkedList(final int noOfNodes) {
        final ListNode root = new ListNode(10);
        ListNode tempRoot = root;
        for (int i = 1; i < noOfNodes; i++) {
            tempRoot.next = new ListNode(i + 3);
            tempRoot = tempRoot.next;
        }
        return root;
    }
}



