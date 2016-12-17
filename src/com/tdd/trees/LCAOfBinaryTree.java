package com.tdd.trees;

public class LCAOfBinaryTree {
    public static void main(String... args) {
        BinaryTreeNode root = BinaryTree.createBalancedTree();
        System.out.println("Least Common ancestor: " + computeLCA(root, 9, 5).value);
        System.out.println("Least Common ancestor: " + computeLCA(root, 8, 7).value);
        System.out.println("Least Common ancestor: " + computeLCA(root, 3, 6).value);
        System.out.println("Least Common ancestor: " + computeLCA(root, 9, 8).value);
    }

    private static BinaryTreeNode computeLCA(BinaryTreeNode root, int node1, int node2) {
        if (root == null)
            return null;
        BinaryTreeNode left = computeLCA(root.left, node1, node2);
        BinaryTreeNode right = computeLCA(root.right, node1, node2);

        if (left != null && right != null) {
            return root;
        }

        if (root.value == node1 || root.value == node2) {
            return root;
        }

        return left != null ? left : right;
    }
}
