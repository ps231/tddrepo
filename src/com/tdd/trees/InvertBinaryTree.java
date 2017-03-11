package com.tdd.trees;

//https://leetcode.com/problems/invert-binary-tree
public class InvertBinaryTree {
    public static void main(final String... args) {
        BinaryTreeNode invertedNode = InvertBinaryTree.invertTree(BinaryTree.createPerfectBinaryTree());
    }

    private static BinaryTreeNode invertTree(BinaryTreeNode root) {

        if(root == null)
            return null;
        invertTree(root.left);
        invertTree(root.right);

        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }
}
