package com.tdd.trees;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafPaths {

    public static void main(final String[] args) {
        SumRootToLeafPaths s = new SumRootToLeafPaths();

        System.out.println(s.calculateSumOfRootToLeafPaths(BinaryTree.createBalancedTree()));
        System.out.println(s.calculateSumOfRootToLeafPaths(BinaryTree.createLeftSkewedTree()));
        System.out.println(s.calculateSumOfRootToLeafPaths(null));
    }

    private int calculateSumOfRootToLeafPaths(final BinaryTreeNode root) {
        final List<String> paths = new ArrayList<>();
        final String currentPath = "";
        sumHelper(root, paths, currentPath);
        int sum = 0;

        for (String path : paths) {
            sum += Integer.parseInt(path);
        }

        return sum;
    }

    private void sumHelper(final BinaryTreeNode root, final List<String> paths, String currentPath) {
        if (root == null)
            return;

        currentPath += root.value;

        sumHelper(root.left, paths, currentPath);
        sumHelper(root.right, paths, currentPath);

        if (root.left == null && root.right == null)
            paths.add(currentPath);
    }
}
