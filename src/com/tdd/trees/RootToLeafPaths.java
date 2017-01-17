package com.tdd.trees;

//https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class RootToLeafPaths {

    public static void main(String[] args) {
        System.out.println("Root to leaf paths sum is : " + sumOfRootToLeafPaths(createTree()));
    }

    private static int sumOfRootToLeafPaths(BinaryTreeNode root) {
        return traverseTreePath(root, "", 0);
    }

    private static int traverseTreePath(BinaryTreeNode root, String traversedNodes, int sumOfAllPaths) {
        if (root == null)
            return 0;

        int leftPathSum = traverseTreePath(root.left, traversedNodes + root.value, sumOfAllPaths);
        int rightPathSum = traverseTreePath(root.right, traversedNodes + root.value, sumOfAllPaths);

        if (root.left == null && root.right == null)
            return Integer.valueOf(traversedNodes + root.value);

        return leftPathSum + rightPathSum;
    }

    private static BinaryTreeNode createTree() {
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = 1;

        BinaryTreeNode left = new BinaryTreeNode();
        left.value = 2;

        BinaryTreeNode right = new BinaryTreeNode();
        right.value = 3;

        root.left = left;
        root.right = right;

        root.left.left = new BinaryTreeNode();
        root.left.left.value = 1;

        root.left.right = new BinaryTreeNode();
        root.left.right.value = 8;

        root.right.left = new BinaryTreeNode();
        root.right.left.value = 4;

        root.right.right = new BinaryTreeNode();
        root.right.right.value = 0;

        return root;
    }
}
