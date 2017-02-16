package com.tdd.trees;

import java.util.Stack;

public class BinaryTreeNonRecursiveTraversals {

    public static void main(String... args) {
        BinaryTreeNode root = BinaryTree.createPerfectBinaryTree();

        System.out.println("inorder traversal");
        inorder(root);

        System.out.println("preorder traversal");
        preorder(root);

//        System.out.println("postorder traversal");
//        postorder(root);
    }

    private static void postorder(BinaryTreeNode root) {
    }

    private static void inorder(BinaryTreeNode root) {
        final Stack<BinaryTreeNode> stack = new Stack<>();
        do {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.value);
            root = root.right;
        } while (!stack.empty() || root != null);

    }

    private static void preorder(BinaryTreeNode root) {
        final Stack<BinaryTreeNode> stack = new Stack<>();
        do {
            while (root != null) {
                System.out.println(root.value);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        } while (!stack.empty() || root != null);
    }

}
