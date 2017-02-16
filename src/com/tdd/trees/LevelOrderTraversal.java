package com.tdd.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String... args) {
        BinaryTreeNode root = BinaryTree.createPerfectBinaryTree();
        levelOrderTraversal(root);
    }

    private static void levelOrderTraversal(final BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();

        if (root != null)
            queue.add(root);

        while (!queue.isEmpty()) {
            final BinaryTreeNode node = queue.poll();

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);

            System.out.println(node.value);
        }
    }
}
