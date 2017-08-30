package com.tdd.trees.bst;

import com.tdd.trees.BinaryTreeNode;

public class SecondLargestNodeInBST {

    public static void main(final String[] args) {
        final SecondLargestNodeInBST s = new SecondLargestNodeInBST();
        s.treeHelper(CreateBST.createBinarySearchTree(), 2, new int[]{0});
    }

    private void treeHelper(BinaryTreeNode root, int kLargest, int[] count) {
        if (root == null || count[0] >= kLargest)
            return;

        treeHelper(root.right, kLargest, count);

        count[0]++;
        if (count[0] == kLargest) {
            System.out.println(root.value);
            return;
        }

        treeHelper(root.left, kLargest, count);
    }
}
