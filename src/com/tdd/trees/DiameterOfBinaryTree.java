package com.tdd.trees;

//https://leetcode.com/problems/diameter-of-binary-tree/#/description
public class DiameterOfBinaryTree {
    static int maxAtNode = Integer.MIN_VALUE;

    public static void main(final String... args) {
        System.out.println(calculateDiameter(getTreeNode()));
    }

    private static int calculateDiameter(final BinaryTreeNode root) {
        calDia(root);
        return maxAtNode;
    }

    private static int calDia(final BinaryTreeNode root) {
        if (root == null)
            return 0;

        int left = calDia(root.left);
        int right = calDia(root.right);

        maxAtNode = Math.max(maxAtNode, left + right);

        return Math.max(left, right) + 1;
    }

    private static BinaryTreeNode getTreeNode() {
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 1;

        BinaryTreeNode left = new BinaryTreeNode();
        left.value = 2;

        BinaryTreeNode right = new BinaryTreeNode();
        right.value = 3;

        root.left = left;
        root.right = right;

        left = new BinaryTreeNode();
        left.value = 4;

        right = new BinaryTreeNode();
        right.value = 5;

        root.left.left = left;
        root.left.right = right;

        left = new BinaryTreeNode();
        left.value = 6;

        root.left.right.left = left;

        return root;
    }
}
