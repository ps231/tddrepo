package com.tdd.trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-right-side-view/?tab=Description
public class RHSOfBinaryTree {

    public static void main(final String... args) {
        RHSOfBinaryTree.rightSideView(BinaryTree.createPerfectBinaryTree()).stream().forEach(System.out::println);
        RHSOfBinaryTree.rightSideView(BinaryTree.createLeftSkewedTree()).stream().forEach(System.out::println);
    }

    private static List<Integer> rightSideView(BinaryTreeNode root) {
        final List<Integer> rhs = new ArrayList<>();
        final Deque<BinaryTreeNode> deque = new LinkedList<>();

        if (root != null) {
            rhs.add(root.value);
            if (root.left != null)
                deque.offer(root.left);
            if (root.right != null)
                deque.offer(root.right);
        }

        while (!deque.isEmpty()) {
            final BinaryTreeNode levelLastNode = deque.peekLast();
            rhs.add(levelLastNode.value);
            while (true) {
                BinaryTreeNode node = deque.poll();
                if (node.left != null)
                    deque.offer(node.left);
                if (node.right != null)
                    deque.offer(node.right);
                if (node == levelLastNode)
                     break;
            }
        }
        return rhs;
    }
}
