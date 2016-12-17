package com.tdd.trees;

/**
 * Created by shindikp on 12/16/16.
 */
public class BinaryTreeRecursiveTraversals {

    public static void main(String... args) {
        BinaryTreeNode root = BinaryTree.createPerfectBinaryTree();

        System.out.println("inorder traversal");
        inorder(root);

        System.out.println("preorder traversal");
        preorder(root);

        System.out.println("postorder traversal");
        postorder(root);

    }

    private static void postorder(BinaryTreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.value);
        }
    }

    private static void preorder(BinaryTreeNode root) {
        if (root != null) {
            System.out.println(root.value);
            preorder(root.left);
            preorder(root.right);
        }
    }

    private static void inorder(BinaryTreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.value);
            inorder(root.right);
        }
    }


}
