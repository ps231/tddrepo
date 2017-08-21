package com.tdd.trees;

public class KDistantNodesOfATree {

    public static void main(final String[] args) {
        KDistantNodesOfATree k = new KDistantNodesOfATree();

        k.printAllNodesKDistanceFromRoot(BinaryTree.createBalancedTree(), 2, 0);
        k.printAllNodesKDistanceFromRoot(BinaryTree.createBalancedTree(), 1, 0);
        k.printAllNodesKDistanceFromRoot(BinaryTree.createBalancedTree(), 0, 0);
    }

    private void printAllNodesKDistanceFromRoot(final BinaryTreeNode root, final int k, final int currentLevel) {

        if (root == null)
            return;

        if (currentLevel > k)
            System.out.println(root.value);

        printAllNodesKDistanceFromRoot(root.left, k, currentLevel + 1);
        printAllNodesKDistanceFromRoot(root.right, k, currentLevel + 1);
    }
}
