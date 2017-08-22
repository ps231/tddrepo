package com.tdd.trees;

//http://blog.gainlo.co/index.php/2016/04/26/deepest-node-in-a-tree/
public class DeepestNodeBT {

    public static void main(final String[] args) {

        DeepestNodeBT d = new DeepestNodeBT();

        System.out.println(d.getDeepestNode(createRandomBinaryTree()).value);
    }

    private static BinaryTreeNode createRandomBinaryTree() {
        final BinaryTreeNode root = BinaryTree.createLeftSkewedTree();
        BinaryTreeNode traverse = root;

        traverse = traverse.left.left;

        traverse.right = new BinaryTreeNode(8, null, null);
        traverse = traverse.right;

        traverse.left = new BinaryTreeNode(10, null, null);
        traverse.right = new BinaryTreeNode(9, null, null);

        return root;
    }

    private BinaryTreeNode getDeepestNode(BinaryTreeNode root) {
        NodeWrap n = deepestNodeHelper(root);
        return n.node;
    }

    private NodeWrap deepestNodeHelper(BinaryTreeNode root) {
        if (root == null)
            return null;

        NodeWrap left = deepestNodeHelper(root.left);
        NodeWrap right = deepestNodeHelper(root.right);

        if (left == null && right == null)
            return new NodeWrap(root, 1);

        if (left != null && right != null) {
            if (left.level >= right.level)
                return new NodeWrap(left.node, left.level + 1);
            else
                return new NodeWrap(right.node, right.level + 1);
        }

        return left == null ? new NodeWrap(right.node, right.level + 1) : new NodeWrap(left.node, left.level + 1);
    }

    private class NodeWrap {
        BinaryTreeNode node;
        int level;

        public NodeWrap(BinaryTreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
