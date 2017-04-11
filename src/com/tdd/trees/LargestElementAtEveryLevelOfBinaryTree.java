package com.tdd.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/find-largest-value-in-each-tree-row/#/description
public class LargestElementAtEveryLevelOfBinaryTree {

    public static void main(final String[] args) {
        getLargestAtEveryLevel(BinaryTree.createBalancedTree()).stream().forEach(System.out::println);
    }

    private static List<Integer> getLargestAtEveryLevel(final BinaryTreeNode root) {
        final List<Integer> elements = new ArrayList<>();
        final Queue<BinaryTreeNode> queue = new LinkedList<>();
        int currentMax = Integer.MIN_VALUE;

        if (root == null)
            return elements;
        else {
            queue.add(root);
            queue.add(null);
        }

        while (!queue.isEmpty()) {
            while (queue.peek() != null) {
                final BinaryTreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                currentMax = Math.max(currentMax, node.value);
            }
            queue.poll();
            if (!queue.isEmpty())
                queue.add(null);
            elements.add(currentMax);
            currentMax = Integer.MIN_VALUE;
        }
        return elements;
    }
}
