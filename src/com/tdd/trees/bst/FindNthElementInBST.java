package com.tdd.trees.bst;

import com.tdd.trees.BinaryTreeNode;

public class FindNthElementInBST {

    public static void main(final String... args) {
        System.out.println("2nd element in BST: " + findNthElem(CreateBST.createBinarySearchTree(), 2, new int[]{0}).value);
    }

    private static BinaryTreeNode findNthElem(BinaryTreeNode head, int n, int[] count) {
        if (head == null)
            return null;

        BinaryTreeNode nthSmallest = null;

        nthSmallest = findNthElem(head.left, n, count);

        if (nthSmallest == null) {
            count[0] += 1;

            if (count[0] == n)
                nthSmallest = head;
        }


        if (nthSmallest == null)
            nthSmallest = findNthElem(head.right, n, count);

        return nthSmallest;
    }
}

