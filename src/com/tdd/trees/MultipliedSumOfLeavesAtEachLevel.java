package com.tdd.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MultipliedSumOfLeavesAtEachLevel {

    public static void main(final String[] args) {
        System.out.println(MultipliedSumOfLeavesAtEachLevel.getMultipliedSumOfLeavesAtEachLevel(createTree()));
    }

    private static BinaryTreeNode createTree() {
        final BinaryTreeNode node = new BinaryTreeNode(2, null, null);
        node.left = new BinaryTreeNode(7, null, null);
        node.left.left = new BinaryTreeNode(8, null, null);
        node.left.right = new BinaryTreeNode(6, null, null);
        node.left.right.left = new BinaryTreeNode(1, null, null);
        node.left.right.right = new BinaryTreeNode(11, null, null);


        node.right = new BinaryTreeNode(5, null, null);
        node.right.right = new BinaryTreeNode(9, null, null);
        node.right.right.left = new BinaryTreeNode(4, null, null);
        node.right.right.right = new BinaryTreeNode(10, null, null);

        return node;
    }

    private static int getMultipliedSumOfLeavesAtEachLevel(final BinaryTreeNode node) {

        if (node == null)
            return 0;

        int multipliedLevel = 1;
        int sumLevel = 0;

        final Queue<BinaryTreeNode> q1 = new LinkedList<>();
        final Queue<BinaryTreeNode> q2 = new LinkedList<>();

        q1.add(node);

        while (queueNotEmpty(q1) || queueNotEmpty(q2)) {
            if (queueNotEmpty(q1)) {
                sumLevel = iterateQueueAndAddChildrenToAnother(sumLevel, q1, q2);
                if (sumLevel > 0) {
                    multipliedLevel *= sumLevel;
                    sumLevel = 0;
                }
            }

            if (queueNotEmpty(q2)) {
                sumLevel = iterateQueueAndAddChildrenToAnother(sumLevel, q2, q1);
                if (sumLevel > 0) {
                    multipliedLevel *= sumLevel;
                    sumLevel = 0;
                }
            }
        }
        return multipliedLevel;
    }

    private static int iterateQueueAndAddChildrenToAnother(int sumLevel, Queue<BinaryTreeNode> currentQ, Queue<BinaryTreeNode> nextQ) {
        while (queueNotEmpty(currentQ)) {
            BinaryTreeNode n = currentQ.poll();
            if (n.left == null && n.right == null)
                sumLevel += n.value;
            if (n.left != null)
                nextQ.add(n.left);
            if (n.right != null)
                nextQ.add(n.right);
        }
        return sumLevel;
    }

    private static boolean queueNotEmpty(Queue<BinaryTreeNode> q) {
        return !q.isEmpty();
    }
}
