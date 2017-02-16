package com.tdd.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {
    public static void main(final String... args) {
        BinaryTreeNode root = BinaryTree.createPerfectBinaryTree();
        reverseLevelOrderTraversal(root);
    }

    private static void reverseLevelOrderTraversal(final BinaryTreeNode root) {
        final Queue<BinaryTreeNode> queue = new LinkedList<>();
        final Stack<BinaryTreeNode> stack = new Stack<>();

        if (root != null)
            queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            if (node.right != null)
                queue.add(node.right);
            if (node.left != null)
                queue.add(node.left);
            stack.push(node);
        }

        while (!stack.empty())
            System.out.println(stack.pop().value);
    }
}
