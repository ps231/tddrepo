package com.tdd.trees;

import java.util.LinkedList;
import java.util.Queue;

//find max width of a Binary Tree, ie max nodes for a level
public class MaxWidthOfABinaryTree {

    public static void main(final String... args) {
        MaxWidthOfABinaryTree b = new MaxWidthOfABinaryTree();
        System.out.println(b.findMaxWidth(BinaryTree.createBalancedAsymmetricTree()));
        System.out.println(b.findMaxWidth(BinaryTree.createLeftSkewedTree()));
    }

    private int findMaxWidth(BinaryTreeNode root) {
        Queue<BinaryTreeNode> q1 = new LinkedList<>();
        Queue<BinaryTreeNode> q2 = new LinkedList<>();
        int maxWidth = Integer.MIN_VALUE;

        if (root != null)
            q1.add(root);

        while (!isEmpty(q1) || !isEmpty(q2)) {
            if (isEmpty(q1)) {
                maxWidth = getMaxWidth(q2, maxWidth);
                addChildrenToNextQueue(q1, q2);
            } else {
                maxWidth = getMaxWidth(q1, maxWidth);
                addChildrenToNextQueue(q2, q1);
            }
        }
        return maxWidth;
    }

    private void addChildrenToNextQueue(Queue<BinaryTreeNode> nextQueue, Queue<BinaryTreeNode> currentQueue) {
        BinaryTreeNode temp;
        while (!isEmpty(currentQueue)) {
            temp = currentQueue.poll();
            add(nextQueue, temp.left);
            add(nextQueue, temp.right);
        }
    }

    private void add(Queue<BinaryTreeNode> nextQueue, BinaryTreeNode temp) {
        if (temp != null)
            nextQueue.add(temp);
    }

    private int getMaxWidth(Queue<BinaryTreeNode> queue, int currentWidth) {
        currentWidth = queue.size() > currentWidth ? queue.size() : currentWidth;
        return currentWidth;
    }

    private boolean isEmpty(Queue<BinaryTreeNode> queue) {
        return queue.isEmpty();
    }
}
