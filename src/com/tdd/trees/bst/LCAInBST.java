package com.tdd.trees.bst;

import com.tdd.trees.BinaryTreeNode;

public class LCAInBST {

    public static void main(final String[] args) {
        LCAInBST b = new LCAInBST();
        final BinaryTreeNode root = CreateBST.createBinarySearchTree();
        System.out.println(b.findLCA(root, 7, 12).value);
        System.out.println(b.findLCA(root, 6, 1).value);
        System.out.println(b.findLCA(root, 1, 6).value);
        System.out.println(b.findLCA(root, 7, 5).value);
        System.out.println(b.findLCA(root, 12, 20).value);
        System.out.println(b.findLCA(root, 1, 7).value);
        System.out.println(b.findLCA(root, 1, 15).value);
        System.out.println(b.findLCA(root, 1, 25).value);
    }

    private BinaryTreeNode findLCA(BinaryTreeNode root, int val1, int val2) {
        if (root == null)
            return null;

        if (root.value < val1 && root.value < val2)
            return findLCA(root.right, val1, val2);
        else if (root.value > val1 && root.value > val2)
            return findLCA(root.left, val1, val2);
        else
            return root;
    }
}
