package com.tdd.trees;

public class MergeBinaryTrees {

    public static void main(final String[] args) {
        final MergeBinaryTrees t = new MergeBinaryTrees();
        final BinaryTreeNode node1 = t.getTreeOne();
        final BinaryTreeNode node2 = t.getTreeTwo();
        final BinaryTreeNode mergedRoot = t.mergeTrees(node1, node2);

    }

    private BinaryTreeNode mergeTrees(BinaryTreeNode node1, BinaryTreeNode node2) {
        BinaryTreeNode root = null;

        if (node1 == null && node2 == null)
            return null;

        if (node1 == null)
            return node2;

        if (node2 == null)
            return node1;

        if (node1 != null && node2 != null)
            root = new BinaryTreeNode(node1.value + node2.value, null, null);

        root.left = mergeTrees(node1.left, node2.left);
        root.right = mergeTrees(node1.right, node2.right);
        return root;
    }

    public BinaryTreeNode getTreeOne() {
        final BinaryTreeNode root = new BinaryTreeNode(1, null, null);
        root.left = new BinaryTreeNode(2, null, null);
        root.left.left = new BinaryTreeNode(3, null, null);

        root.right = new BinaryTreeNode(5, null, null);
        root.right.left = new BinaryTreeNode(8, null, null);
        return root;
    }

    public BinaryTreeNode getTreeTwo() {
        final BinaryTreeNode root = new BinaryTreeNode(3, null, null);
        root.left = new BinaryTreeNode(4, null, null);
        root.left.left = new BinaryTreeNode(6, null, null);
        root.left.right = new BinaryTreeNode(5, null, null);

        root.right = new BinaryTreeNode(5, null, null);
        root.right.right = new BinaryTreeNode(10, null, null);
        return root;
    }
}
