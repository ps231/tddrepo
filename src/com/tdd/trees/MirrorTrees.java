package com.tdd.trees;

//see if two trees are mirror images of each other
public class MirrorTrees {
    public static void main(final String[] args) {
        System.out.println(MirrorTrees.checkIfMirror(createTree(), createMirrorTree()));
    }

    private static boolean checkIfMirror(final BinaryTreeNode n1, final BinaryTreeNode n2) {

        if (n1 == null && n2 == null)
            return true;

        if ((n1 == null && n2 != null) || (n2 == null && n1 != null))
            return false;

        return n1.value == n2.value
                && checkIfMirror(n1.left, n2.right)
                && checkIfMirror(n1.right, n2.left);
    }

    private static BinaryTreeNode createMirrorTree() {
        final BinaryTreeNode root = new BinaryTreeNode(1, null, null);

        root.left = new BinaryTreeNode(4, null, null);
        root.right = new BinaryTreeNode(2, null,  null);

        root.left.right = new BinaryTreeNode(5, null, null);
        root.right.left = new BinaryTreeNode(3, null, null);

        return root;
    }

    private static BinaryTreeNode createTree() {
        final BinaryTreeNode root = new BinaryTreeNode(1, null, null);

        root.left = new BinaryTreeNode(2, null, null);
        root.right = new BinaryTreeNode(4, null,  null);

        root.left.right = new BinaryTreeNode(3, null, null);
        root.right.left = new BinaryTreeNode(5, null, null);



        return root;
    }
}
