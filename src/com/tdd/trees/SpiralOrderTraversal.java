package com.tdd.trees;

import java.util.Stack;

public class SpiralOrderTraversal {
    public static void main(final String... args) {
        BinaryTreeNode root = BinaryTree.createBalancedAsymmetricTree();
        spiralOrderTraversal(root);
    }

    private static void spiralOrderTraversal(final BinaryTreeNode root) {
        Stack<BinaryTreeNode> s1 = new Stack<>();
        Stack<BinaryTreeNode> s2 = new Stack<>();

        if (root != null)
            s1.push(root);

        BinaryTreeNode node = null;

        do {
            while (!s1.empty()) {
                node = s1.pop();
                if (node.left != null)
                    s2.push(node.left);
                if (node.right != null)
                    s2.push(node.right);
                System.out.println(node.value);
            }

            while (!s2.empty()) {
                node = s2.pop();
                if (node.right != null)
                    s1.push(node.right);
                if (node.left != null)
                    s1.push(node.left);
                System.out.println(node.value);
            }

        } while (!s1.empty() || !s2.empty());
    }
}
