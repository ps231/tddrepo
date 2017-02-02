package com.tdd.trees.bst;

import com.tdd.trees.BinaryTreeNode;

public class CreateBST {

    public static BinaryTreeNode createBinarySearchTree() {
        final BinaryTreeNode root = new BinaryTreeNode(8, null, null);

        root.left = new BinaryTreeNode(6, null, null);
        root.left.left = new BinaryTreeNode(3, null, null);
        root.left.left.left = new BinaryTreeNode(1, null, null);
        root.left.left.right = new BinaryTreeNode(5, null, null);
        root.left.right = new BinaryTreeNode(7, null, null);
        root.right = new BinaryTreeNode(15, null, null);
        root.right.left = new BinaryTreeNode(12, null, null);
        root.right.right = new BinaryTreeNode(20, null, null);

        return root;
    }
}
