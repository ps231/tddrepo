package com.tdd.trees;

public class HeightBalancedTree {
    public static void main(String... args) {
        BinaryTreeNode root = BinaryTree.createBalancedTree();
        calculateHeightBalance(root);
        System.out.println("Binary Tree balanced");

        root = BinaryTree.createLeftSkewedTree();
        calculateHeightBalance(root);
        System.out.println("Binary Tree balanced");
    }

    private static int calculateHeightBalance(BinaryTreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = calculateHeightBalance(root.left);
        int rightHeight = calculateHeightBalance(root.right);

        if(!(Math.abs(leftHeight - rightHeight) == 1 || leftHeight - rightHeight == 0)) {
            System.out.println("Height compared at node " + root.value + ": Tree not height balanced");
            System.exit(-1);
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
