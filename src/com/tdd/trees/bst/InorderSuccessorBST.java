package com.tdd.trees.bst;

import com.tdd.trees.BinaryTreeNode;

public class InorderSuccessorBST {
    public static void main(final String[] args) {
        final InorderSuccessorBST b = new InorderSuccessorBST();
        final BinaryTreeNode root = createBinaryTree();
        System.out.println(b.getInorderSuccessor(root, 7).value);
        System.out.println(b.getInorderSuccessor(root, 5).value);
        System.out.println(b.getInorderSuccessor(root, 3).value);
        System.out.println(b.getInorderSuccessor(root, 9).value);
        System.out.println(b.getInorderSuccessor(root, 27).value);
    }

    private BinaryTreeNode getInorderSuccessor(BinaryTreeNode root, final int value) {
        final BinaryTreeNode current = findNode(root, value);
        if (current != null) {
            if (current.right != null)
                return findMin(current.right);
            else {
                BinaryTreeNode successor = null;
                BinaryTreeNode ancestor = root;
                while (ancestor != current) {
                    if (current.value < ancestor.value) {
                        successor = ancestor;
                        ancestor = ancestor.left;
                    } else {
                        ancestor = ancestor.right;
                    }
                }
                return successor;
            }
        }
        return null;
    }

    private BinaryTreeNode findMin(BinaryTreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private BinaryTreeNode findNode(final BinaryTreeNode root, final int value) {
        if (root == null)
            return null;

        if (root.value < value)
            return findNode(root.right, value);
        else if (root.value > value)
            return findNode(root.left, value);
        else
            return root;
    }

    private static BinaryTreeNode createBinaryTree() {
        final BinaryTreeNode root = new BinaryTreeNode(10, null, null);
        root.left = new BinaryTreeNode(5, null, null);
        root.left.left = new BinaryTreeNode(3, null, null);
        root.left.right = new BinaryTreeNode(7, null, null);
        root.left.right.left = new BinaryTreeNode(6, null, null);
        root.left.right.right = new BinaryTreeNode(9, null, null);
        root.right = new BinaryTreeNode(16, null, null);
        root.right.right = new BinaryTreeNode(28, null, null);
        root.right.right.left = new BinaryTreeNode(19, null, null);
        root.right.right.left.right = new BinaryTreeNode(27, null, null);

        return root;
    }
}
