package com.tdd.trees;

public class TreeHeight {
    public static void main(String... args) {
        System.out.println("Tree height is " + calculateHeight(BinaryTree.createPerfectBinaryTree()));
        System.out.println("Tree height is " + calculateHeight(BinaryTree.createLeftSkewedTree()));
    }

    private static int calculateHeight(BinaryTreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
