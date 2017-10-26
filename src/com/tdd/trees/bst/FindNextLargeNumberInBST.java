package com.tdd.trees.bst;

import com.tdd.trees.BinaryTreeNode;

public class FindNextLargeNumberInBST {

    public static void main(final String... args) {
        final BinaryTreeNode root = CreateBST.createBinarySearchTree();
        System.out.println("Node after 12 is " + findNextLargeNumber(root, 12, -1));
        System.out.println("Node after 7 is " + findNextLargeNumber(root, 7, -1));
        System.out.println("Node after 1 is " + findNextLargeNumber(root, 1, -1));
        System.out.println("Node after 5 is " + findNextLargeNumber(root, 5, -1));
        System.out.println("Node after 8 is " + findNextLargeNumber(root, 8, -1));

    }

    private static int findNextLargeNumber(BinaryTreeNode root, int number, int currentNextLarge) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        if (root.value > number)
            currentNextLarge = findNextLargeNumber(root.left, number, root.value);
        else if (root.value < number)
            currentNextLarge = findNextLargeNumber(root.right, number, currentNextLarge);
        else
            currentNextLarge = root.right != null ? getLeftMost(root.right) : currentNextLarge;

        return currentNextLarge;
    }

    private static int getLeftMost(final BinaryTreeNode root) {
        BinaryTreeNode temp = root;
        while (temp.left != null)
            temp = temp.left;
        return temp.value;
    }
}
