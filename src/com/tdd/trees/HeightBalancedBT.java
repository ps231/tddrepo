package com.tdd.trees;

public class HeightBalancedBT {

    public static void main(final String[] args) {
        System.out.println("is tree height balanced ? " + new HeightBalancedBT().isHeightBalanced(BinaryTree.createBalancedTree()).balanced);
        System.out.println("is tree height balanced ? " + new HeightBalancedBT().isHeightBalanced(BinaryTree.createLeftSkewedTree()).balanced);
        System.out.println("is tree height balanced ? " + new HeightBalancedBT().isHeightBalanced(BinaryTree.createBalancedAsymmetricTree()).balanced);
        System.out.println("is tree height balanced ? " + new HeightBalancedBT().isHeightBalanced(BinaryTree.createBalancedSymmetricTree()).balanced);
        System.out.println("is tree height balanced ? " + new HeightBalancedBT().isHeightBalanced(BinaryTree.createPerfectBinaryTree()).balanced);
    }

    private NodeBalance isHeightBalanced(final BinaryTreeNode node) {

        if (node == null)
            return new NodeBalance(null, true, 0);

        NodeBalance left = isHeightBalanced(node.left);
        NodeBalance right = isHeightBalanced(node.right);

        if (left.height == right.height)
            return new NodeBalance(node, true, left.height + 1);
        else
            return new NodeBalance(node, false, -1);
    }

    private class NodeBalance {
        BinaryTreeNode node;
        boolean balanced;
        int height;

        public NodeBalance(BinaryTreeNode node, boolean balanced, int height) {
            this.node = node;
            this.balanced = balanced;
            this.height = height;
        }
    }
}
