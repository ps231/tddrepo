package com.tdd.trees.bst;

import com.tdd.trees.BinaryTreeNode;

// check if binary tree is a binary search tree
public class CheckBinaryTreeForBST {

    public static void main(final String... args) {
        final BinaryTreeNode root = createBinaryTree(false);

        int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;

        boolean isBST = checkForBST(root, min, max);
        if (isBST)
            System.out.println("Binary Tree satisfies BST property");
        else
            System.out.println("Binary Tree does not satisfy BST property");
    }

    private static boolean checkForBST(BinaryTreeNode root, int min, int max) {
        if (root == null)
            return true;

        boolean left = checkForBST(root.left, Math.min(min, root.value), Math.min(max, root.value));
        boolean right = checkForBST(root.right, root.value, max);

        return left && right && root.value > min && root.value < max ? true : false;
    }

    private static BinaryTreeNode createBinaryTree(final boolean isBST) {

        final BinaryTreeNode root = new BinaryTreeNode(8, null, null);

        root.left = new BinaryTreeNode(6, null, null);
        root.left.left = new BinaryTreeNode(3, null, null);
        root.left.left.left = new BinaryTreeNode(1, null, null);
        root.left.left.right = new BinaryTreeNode(5, null, null);
        if (isBST)
            root.left.right = new BinaryTreeNode(7, null, null);
        else
            root.left.right = new BinaryTreeNode(9, null, null);

        root.right = new BinaryTreeNode(15, null, null);
        if (isBST)
            root.right.left = new BinaryTreeNode(12, null, null);
        else
            root.right.left = new BinaryTreeNode(7, null, null);
        root.right.right = new BinaryTreeNode(20, null, null);

        return root;
    }
}
